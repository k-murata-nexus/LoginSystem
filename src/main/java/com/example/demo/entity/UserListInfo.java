package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserListInfo {

	/** ログインID */
	private String loginId;
	
	/** 契約日時 */
	private LocalDateTime contractTime;
	
	/** ログイン失敗回数 */
	private int loginFailureCount;
	
	/** アカウントロック日時 */
	private LocalDateTime accountLockedTime;
	
	/** アカウント状態 */
	private String userStatusKind;

	/** 権限 */
	private String authorityKind;
	
	/** 登録日時 */
	private LocalDateTime createTime;
	
	/** 最終更新日時 */
	private LocalDateTime updateTime;
	
	/** 最終更新ユーザ */
	private String updateUser;

}
