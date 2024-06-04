package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.entity.DetailInfo;
import com.example.demo.form.DetailedForm;
import com.example.demo.service.DetailedService;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * 詳細情報入力コントローラー
 * 
 * @author k-murata
 * 
 */
@Controller
@RequiredArgsConstructor
public class DetailController {
	
	/** 画面で使用するフォームクラス名 */
	private static final String FORM_CLASS_NAME = "detailedForm";
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** ユーザ編集画面Serviceクラス */
	private final DetailedService service;
	

	@GetMapping(UrlConst.DETAILED)
	public String view(Model model,DetailedForm form) {
		var isInitialDisp = !model.containsAttribute(FORM_CLASS_NAME);
		if(isInitialDisp) {
			model.addAttribute(FORM_CLASS_NAME,new DetailedForm());
		}
		return ViewNameConst.DETAILED;
	}
	
	@PostMapping(UrlConst.DETAILED)
	public String signup(Model model,DetailedForm form,@AuthenticationPrincipal User user) {
		var updateDto = mapper.map(form, DetailInfo.class);
		updateDto.setLoginId(user.getUsername());
		service.detail(updateDto);
		
		model.addAttribute("message",MessageConst.DETAIL_TELEPHONE_NUMBER);


		return AppUtil.doRedirect(UrlConst.MENU);
	}
	


}
