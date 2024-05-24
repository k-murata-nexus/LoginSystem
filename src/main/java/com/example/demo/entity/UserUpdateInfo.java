package com.example.demo.entity;

import com.example.demo.constant.db.AuthorityKind;
import com.example.demo.constant.db.UserStatusKind;

import lombok.Data;

@Data
public class UserUpdateInfo {

	/** ログインID */
	private String loginId;
	
	/** ログイン状況をリセットするか(リセットするならtrue) */
	private boolean resetsLoginFailure;
	
	/** アカウント状態種別 */
	private UserStatusKind userStatusKind;
	
	/** ユーザ権限種別 */
	private AuthorityKind authorityKind;
	
	/** 更新ユーザID */
	private String updateUserId;
}
