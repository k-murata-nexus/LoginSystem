package com.example.demo.service;

import com.example.demo.entity.DetailInfo;

/**
 * ユーザ詳細情報登録画面Serviceインターフェース
 * 
 * @author k-murata
 */

public interface DetailedService {
	
	/**
	 * 画面の入力情報を元に詳細情報の登録を行います。
	 * 
	 * @param dto 詳細情報
	 */
	public void detail(DetailInfo dto);
}
