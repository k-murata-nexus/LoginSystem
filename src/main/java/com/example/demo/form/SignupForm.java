package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * ユーザ登録画面 form
 * 
 * @author k-murata
 */
@Data
public class SignupForm {
	
	/** ログインID */
	@Length(min=3,max=20)
	private String loginId;
	
	/** パスワード */
	@Length(min=5,max=20)
	private String password;
	
	/** 契約時刻 */
	private String contract_time;
	
	/***/
	@Length(max=100)
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@([A-Za-z0-9][A-Za-z0-9-]*[A-Za-z0-9]*\\.)+[A-Za-z]{2,}$",message="{signup.invalidMailAddress}")
	private String mailAddress;
}
