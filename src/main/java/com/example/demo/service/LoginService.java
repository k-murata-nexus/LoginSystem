package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面 Servie
 * 
 * @author k-murata
 * 
 */

@Service
@RequiredArgsConstructor
public class LoginService {
	
	/** ユーザ情報テーブルDAO */
	private final UserInfoRepository repository;
	
	/**
	 * ユーザ情報テーブル 主キー検索
	 * @param loginId ログインID
	 * @return 検索結果
	 */
	public Optional<UserInfo>serchUserById(String loginId){
		return repository.findById(loginId);
	}

}
