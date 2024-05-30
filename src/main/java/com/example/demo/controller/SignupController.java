package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.SessionKeyConst;
import com.example.demo.constant.SignupResult;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.entity.SignupInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
/**
 * ユーザ登録画面 Controller
 * 
 * @author k-murata
 * 
 */
@RequiredArgsConstructor
public class SignupController {
	
	/** ユーザ登録画面 service */
	private final SignupService service;
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	/** オブジェクト間項目輸送クラス */
	private final Mapper mapper;
	
	/** セッションオブジェクト */
	private final HttpSession session;
	
	/** 画面で使用するフォームクラス名 */
	private static final String FORM_CLASS_NAME = "signForm";
	
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping(UrlConst.SIGNUP)
	public String view(Model model,SignupForm form) {
		var isInitialDisp = !model.containsAttribute(FORM_CLASS_NAME);
		if(isInitialDisp) {
			model.addAttribute(FORM_CLASS_NAME,new SignupForm());
		}
		return ViewNameConst.SIGNUP;
	}
	
	/**
	 * ユーザ登録
	 * @param model モデル
	 * @param form 入力情報
	 * @param dbResult 入力チェック結果
	 * @return 表示画面
	 */
	@PostMapping(UrlConst.SIGNUP)
	public String signup(@Validated SignupForm form,BindingResult bdResult,RedirectAttributes redirectAttributes) {
		if(bdResult.hasErrors()) {
			editGuideMessage(form,bdResult,MessageConst.FORM_ERROR,redirectAttributes);
			return AppUtil.doRedirect(UrlConst.SIGNUP);
		}
		
		var signupResult = service.signup(mapper.map(form,SignupInfo.class));
		var isError = signupResult != SignupResult.SUCCEED;
		if(isError) {
			editGuideMessage(form,bdResult,signupResult.getMessageId(),redirectAttributes);
			return AppUtil.doRedirect(UrlConst.SIGNUP);
		}
		
		session.setAttribute(SessionKeyConst.ONE_TIME_AUTH_LOGIN_ID,form.getLoginId());
		return AppUtil.doRedirect(UrlConst.SIGNUP_CONFIRM);
	}

	/**
	 * 
	 * @param userInfoOpt ユーザ登録結果(登録済みだった場合はEmpty)
	 * @return メッセージキー
	 */
//	private SignupMessage judgeMessageKey(Optional<UserInfo> userInfoOpt) {
//		if(userInfoOpt.isEmpty()) {
//			return SignupMessage.EXISTED_LOGIN_ID;
//		}else {
//			return SignupMessage.SUCCEED;
//		}
//	}
	
	/**
	 * メッセージIDを使ってプロパティファイルからメッセージを取得し、画面に表示します。
	 * 
	 * <p>また、画面でメッセージを表示する際に通常メッセージをエラーメッセージとで色分けをするため、<br>
	 * その判定に必要な情報も画面に渡します。
	 * 
	 * @param form 入力情報
	 * @param bdResult 入力内容の短項目チェック結果
	 * @param messageId プロパティファイルから取得したいメッセージのID
	 * @param isError エラー有無
	 * @param redirectAttributes リダイレクト用モデル
	 */
	private void editGuideMessage(SignupForm form,BindingResult bdResult,String messageId,
						RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message",AppUtil.getMessage(messageSource, messageId));
		redirectAttributes.addFlashAttribute("isError",true);
		redirectAttributes.addFlashAttribute(form);
		redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + FORM_CLASS_NAME,bdResult);
	}
}
