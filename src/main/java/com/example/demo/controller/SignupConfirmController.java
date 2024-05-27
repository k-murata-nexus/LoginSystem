package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.SessionKeyConst;
import com.example.demo.constant.SignupConfirmStatus;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.service.SignupConfirmService;
import com.example.demo.util.AppUtil;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignupConfirmController {
	
	/** 仮登録画面サービス */
	private final SignupConfirmService service;
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	/** セッションオブジェクト */
	private final HttpSession session;
	
	@GetMapping(UrlConst.SIGNUP_CONFIRM)
	public String view() {
		return ViewNameConst.SIGNUP_CONFIRM;
	}
	
	@PostMapping(UrlConst.SIGNUP_CONFIRM)
	public String signup(String oneTimeCode,RedirectAttributes redirectAttributes) {
		var loginId = (String)session.getAttribute(SessionKeyConst.ONE_TIME_AUTH_LOGIN_ID);
		if(loginId == null) {
			redirectAttributes.addFlashAttribute("message",MessageConst.SIGNUP_CONFIRM_INVALID_OPERATION);
			redirectAttributes.addFlashAttribute("isError",true);
			return AppUtil.doRedirect(UrlConst.SIGNUP_CONFIRM);
		}
		
		var signupConfirmStatus = service.chkTentativeSignupUser(loginId,oneTimeCode);
		
		//次画面にワンタイムコード認証結果の情報を渡す
		var messageId = AppUtil.getMessage(messageSource, signupConfirmStatus.getMessageId());
		var isError = signupConfirmStatus != SignupConfirmStatus.SUCCEED;
		redirectAttributes.addFlashAttribute("message",messageId);
		redirectAttributes.addFlashAttribute("isError",isError);
		if(isError) {
			return AppUtil.doRedirect(UrlConst.SIGNUP_CONFIRM);
		}
		
		session.removeAttribute(SessionKeyConst.ONE_TIME_AUTH_LOGIN_ID);
		return AppUtil.doRedirect(UrlConst.SIGNUP_COMPLETION);
	}

}
