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
	
	/** ユーザ登録画面:すでに本登録済み */
	public static final String SIGNUP_ALREADY_COMPLETED = "signup.alreadyCompleted";
	
	/**ユーザ登録画面:仮登録状態のログインID*/
	public static final String SIGNUP_SIGNUP_PROCEEDING = "signup.signupProceeding";
	
	/** ユーザ登録画面:DB更新エラー */
	public static final String SIGNUP_DB_ERROR = "signup.dbError";

	/** ユーザ登録画面:メール送信失敗 */
	public static final String SIGNUP_MAIL_SEND_ERROR = "signup.mailSendError";
	
	/**  */
	public static final String SIGNUP_TENTATIVE_SUCCEED = "signup.tentativeSucceed";
	
	/** ユーザ登録画面:既に登録されているログインID */
	public static final String SIGNUP_EXITED_LOGINID = "signup.existedLoginId";
	
	/** ユーザ登録:ユーザ登録完了 */
	public static final String SIGNUP_RESIST_SUCCEED = "signup.resistSucceed";
	
	/** ユーザ登録:ユーザ登録完了 */
	public static final String DETAIL_TELEPHONE_NUMBER = "detailed.TelephoneNumber";

	
	/** ユーザ登録情報確認画面：既に本登録済み */
	public static final String SIGNUP_CONFIRM_ALREADY_COMPLETED = "signupConfirm.alreadyCompleted";

	/** ユーザ登録情報確認画面：不正な画面操作 */
	public static final String SIGNUP_CONFIRM_INVALID_OPERATION = "signupConfirm.invalidOperation";

	/** ユーザ登録情報確認画面：仮登録されていない */
	public static final String SIGNUP_CONFIRM_NOT_EXISTS_TENTATIVE_USER = "signupConfirm.notExistsTentativeUser";

	/** ユーザ登録情報確認画面：ワンタイムコード誤り */
	public static final String SIGNUP_CONFIRM_WRONG_ONE_TIME_CODE = "signupConfirm.wrongOneTimeCode";

	/** ユーザ登録情報確認画面：ワンタイムコード有効期限切れ */
	public static final String SIGNUP_CONFIRM_EXPIRED_ONE_TIME_CODE = "signupConfirm.expiredOneTimeCode";

	/** ユーザ登録情報確認画面：DB更新時エラー */
	public static final String SIGNUP_CONFIRM_DB_ERROR = "signupConfirm.dbError";

	/** ユーザ登録情報確認画面：ユーザー本登録完了 */
	public static final String SIGNUP_CONFIRM_COMPLETE = "signupConfirm.complete";
	
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
