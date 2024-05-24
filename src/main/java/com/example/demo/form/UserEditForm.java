package com.example.demo.form;

import com.example.demo.constant.db.AuthorityKind;
import com.example.demo.constant.db.UserStatusKind;

import lombok.Data;

/**
 *ユーザ登録画面Formクラス
 *
 * @author k-murata
 * 
 */

@Data
public class UserEditForm {
	
	/** ログイン失敗状況をリセット可否 */
	private boolean resetsLoginFailure;
	
	/** アカウント状態種別 */
	private UserStatusKind userStatusKind;
	
	/** ユーザ権限種別 */
	private AuthorityKind authorityKind;
}