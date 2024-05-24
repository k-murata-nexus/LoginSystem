package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * ユーザ編集情報DTOクラス
 * 
 * @author k-murata
 * 
 */

@Data
public class UserEditInfo {

	/** ログインID */
	private String loginId;
	
	/** ログイン失敗回数 */
	private	 int loginFailureCount;
	
	/** アカウントロック日時 */
	private LocalDateTime accountLockedTime;
}
