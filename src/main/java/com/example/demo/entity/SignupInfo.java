package com.example.demo.entity;

import lombok.Data;

/**
 * ユーザ登録用DTOクラス
 * 
 * @author k-murata
 * 
 */

@Data
public class SignupInfo {

	/** ログインID */
	private String loginId;
	
	/** パスワード */
	private String password;
	
	/** メールアドレス */
	private String mailAddress;
}
