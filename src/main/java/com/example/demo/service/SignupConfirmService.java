package com.example.demo.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupConfirmService {

	/** ユーザ情報テーブルRepositoryクラス */
	private final UserInfoRepository repository;
	
	/** パスワードエンコーダー */
	private final PasswordEncoder passwordEncoder;
	
	/** ワンタイムコード有効期間 */
	@Value("${one-time-code.valid-time}")
	private Duration oneTimeCodeVAlidTime = Duration.ZERO;
}
