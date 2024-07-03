package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.demo.entity.UserComListInfo;
import com.example.demo.entity.UserInfo;
import com.github.dozermapper.core.Mapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommunicationReadingService {

	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** セッション情報 */
	private final HttpSession session;
	
	/** 連絡情報呼び出し */
	public List<UserComListInfo> toComReadListInfos(List<UserInfo> userInfos){
		var userComListInfos = new ArrayList<UserComListInfo>();
		return userComListInfos;
	}
}
