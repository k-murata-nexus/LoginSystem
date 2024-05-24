package com.example.demo.constant;

/**
 * URL 定数クラス
 * 
 * @author k-murata
 * 
 */
public class UrlConst {
	/** ログイン画面 */
	public static final String LOGIN = "/login";

	/** ユーザー登録画面 */
	public static final String SIGNUP = "/signup";
	
	/** メニュー画面 */
	public static final String MENU = "/menu";
	
	/** メニュー画面 */
	public static final String CONTRACT = "/contract";
	
	/** 認証不要画面 */
	public static final String[] NO_AUTHENTICATION = {LOGIN,SIGNUP,"/webjars/**","/css/**"};
	
	/** ユーザ管理画面 */
	public static final String USER_LIST = "/userList";
	
	/** ユーザ情報編集画面 */
	public static final String USER_EDIT = "/userEdit";
	
	/** ユーザ情報編集画面_エラー時 */
	public static final String USER_EDIT_ERROR = "/userEditError";

}