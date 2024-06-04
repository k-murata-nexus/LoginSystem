package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * 詳細情報入力フォーム
 * 
 * @author k-murata
 * 
 */

@Data
public class DetailedForm {
	/** 会社名 */
	@Length(min=3,max=100)
	private String companyName;
	
	/** 会社所在地 */
	@Length(min=5,max=100)
	private String companyAddress;
	
	/** 電話番号 */
	@Length(max=100)
	@Pattern(regexp="^[0-9-]+[0-9]{3,}$",message="{detailed.TelephoneNumber}")
	private String telephoneNumber;
}
