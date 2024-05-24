package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import com.example.demo.constant.db.AuthorityKind;
import com.example.demo.constant.db.UserStatusKind;

import lombok.Data;

/**
 * ユーザ登録画面Formクラス
 * 
 * @author k-murata
 * 
 */

@Data
public class UserListForm {

	/** ログインID */
	@Length(min=4,max=20)
	private String loginId;
	
	/** アカウント状態種別 */
	private UserStatusKind userStatusKind;
	
	/** ユーザ権限種別 */
	private AuthorityKind authorityKind;
	
	/** ユーザ一覧情報から選択されたログインID */
	private String selectedLoginId;
	
	/**
	 * ユーザ一覧情報から選択されたログインIDをクリアします。
	 * 
	 * @return
	 */
	public UserListForm clearSelectedLoginId() {
		this.selectedLoginId=null;
		
		return this;
	}
}
