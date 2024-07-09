package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.form.UserListForm;
import com.example.demo.service.CommunicationInputServiceImpl;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * ユーザ一覧画面Controllerクラス
 * 
 * @author k-murata
 * 
 */
@Controller
@RequiredArgsConstructor
public class CommunicationInputController {
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** ユーザ一覧画面Serviceクラス */
	private final CommunicationInputServiceImpl service;
	
	/** 連絡画面表示 */
	public String view(Model model,UserListForm form) {
		return null;
	}
	
}
