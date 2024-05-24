package com.example.demo.constant;

/**
 * エラーメッセージID定数クラス 
 * @author k-murata
 * 
 */
public class MessageConst {
	
	/** 共通:入力内容誤り */
	public static final String FORM_ERROR = "common.formError";
	
	/** ログイン画面:入力内容誤り */
	public static final String LOGIN_WRONG_INPUT = "login.wrongInput";

	/** ユーザ登録画面:既に登録されているログインID */
	public static final String SIGNUP_EXITED_LOGINID = "signup.existedLoginId";
	
	/** ユーザ登録:ユーザ登録完了 */
	public static final String SIGNUP_RESIST_SUCCEED = "signup.resistSucceed";
	
	/** ユーザ一覧画面:存在しないログインID */
	public static final String USERLIDT_NON_EXISTED_LOGIN_ID = "userList.nonExistedLoginId";
	
	/** ユーザ一覧画面:ユーザ削除完了 */
	public static final String USERLIST_DELETE_SUCCEED = "userList.deleteSucceed";
	
	/** ユーザ編集画面:更新成功 */
	public static final String USEEDIT_UPDATE_SUCCEED = "userEdit.updateSucceed";
	
	/** ユーザ編集画面:更新失敗 */
	public static final String USEREDIT_UPDATE_FAILED = "useEdit.updateFailed";
	
	/** ワンタイムコード送信メール:タイトル */
	public static final String SIGNUP_MAIL_SUBJECT = "signup.mailSubject";
	
	/** ワンタイムコード送信メール:本文 */
	public static final String SIGNUP_MAIL_TEXT = "signup.mailText";
	
}
