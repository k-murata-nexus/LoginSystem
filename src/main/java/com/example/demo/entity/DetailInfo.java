package com.example.demo.entity;

import lombok.Data;

/**
 * 詳細情報登録用DTOクラス
 * 
 * @author k-murata
 * 
 */

@Data
public class DetailInfo {
	
	/** ログインID */
	private String loginId;
	
	/** 会社名 */
	private String companyName;
	
	/** 会社所在地 */
	private String companyAddress;
	
	/** 電話番号 */
	private String telephoneNumber;

}
