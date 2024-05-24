package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.SignupMessage;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;
import com.example.demo.util.AppUtil;

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
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping(UrlConst.SIGNUP)
	public String view(Model model,SignupForm form) {
		
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
	public void signup(Model model,@Validated SignupForm form,BindingResult bdResult) {
		if(bdResult.hasErrors()) {
			var message=AppUtil.getMessages(messageSource, MessageConst.FORM_ERROR);
			model.addAttribute("message",message);
		}
		var userInfoOpt = service.resistUserInfo(form);
		var signupMessage=judgeMessageKey(userInfoOpt);
		var messageId=AppUtil.getMessages(messageSource, signupMessage.getMessageId());
		model.addAttribute("message",messageId);
		model.addAttribute("isError",signupMessage.isError());
		
	}

	/**
	 * 
	 * @param userInfoOpt ユーザ登録結果(登録済みだった場合はEmpty)
	 * @return メッセージキー
	 */
	private SignupMessage judgeMessageKey(Optional<UserInfo> userInfoOpt) {
		if(userInfoOpt.isEmpty()) {
			return SignupMessage.EXISTED_LOGIN_ID;
		}else {
			return SignupMessage.SUCCEED;
		}
	}
}
