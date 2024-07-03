package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.form.ComReadingForm;
import com.example.demo.service.UserComListService;
import com.github.dozermapper.core.Mapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommunicationReadingController {

	/** Dozer Mapper */
	private final Mapper mapper;
	
	/**  */
	private UserComListService service;
	
	/** セッション情報 */
	private final HttpSession session;
	
	/**  */
	public String view(Model model,ComReadingForm form) {
		return "";
	}
}
