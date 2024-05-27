package com.example.demo.constant;

public class SignupConfirmStatus {

	private String messageId;
	
	public static final SignupConfirmStatus FAILURE_BY_EXISTS_TENTATIVE_USER = null;
	public static final SignupConfirmStatus FAILURE_BY_WRONG_ONE_TIME_CODE = null;
	public static final SignupConfirmStatus FAILURE_BY_EXPIRED_ONE_TIME_CODE = null;
	public static final SignupConfirmStatus FAILURE_BY_DB_ERROR = null;
	public static final SignupConfirmStatus SUCCEED = null;
	public Object getMessageId() {
		return messageId;
	}

}
