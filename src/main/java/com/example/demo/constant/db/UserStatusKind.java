package com.example.demo.constant.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザ状態種別
 * 
 * @author k-murata
 * 
 */

@Getter
@AllArgsConstructor
public enum UserStatusKind {

	/* 使用可能 */
	ENABLED(false,"利用可能"),
	
	/* 使用不可 */
	DISABLED(true,"利用不可");
	
	/** DB登録値 */
	private boolean disabled;

	/** 画面表示する説明文*/
	private String displayValue;

}
