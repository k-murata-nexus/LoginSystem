package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;

/**
 * ユーザ登録情報確認結果画面Controllerクラス
 * 
 * @author k-murata
 * 
 */

@Controller
public class SignupCompletionController {
	
	/**
	 * 画面の初期表示を行います。
	 * 
	 * @return ユーザ登録情報確認結果画面
	 */
	@GetMapping(UrlConst.SIGNUP_COMPLETION)
	public String view(Model model) {
		return ViewNameConst.SIGNUP_CONPLETION;
	}
}
