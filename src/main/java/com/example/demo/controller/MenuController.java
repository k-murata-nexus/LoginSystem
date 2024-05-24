package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.constant.db.AuthorityKind;
import com.example.demo.service.MenuService;

import lombok.RequiredArgsConstructor;

/**
 * メニューコントローラー
 * 
 * @author k-murata
 */
@Controller
@RequiredArgsConstructor
public class MenuController {
	
	/** ログイン画面 service */
	private final MenuService service;
	
	/**
	 * 初期表示
	 * @return 表示画面
	 */
	@GetMapping(UrlConst.MENU)
	public String view(@AuthenticationPrincipal User user,Model model) {
		

		
		var hasUserManageAuth = user.getAuthorities().stream()
				.allMatch(authority -> authority.getAuthority()
						.equals(AuthorityKind.ITEM_AND_USER_MANAGER.getCode()));
		var userInfo=service.serchUserById(user.getUsername());
		var unSigned = userInfo.get().getContract_time()==null;

		model.addAttribute("hasUserManageAuth",hasUserManageAuth);
		model.addAttribute("unSigned",unSigned);
		
		return ViewNameConst.MENU;
	}
}
