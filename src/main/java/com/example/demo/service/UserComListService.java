package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserComListInfo;
import com.example.demo.entity.UserSearchInfo;

public interface UserComListService {
	/**
	 * ユーザ情報テーブルを全件検索し、ユーザ一覧画面に必要な情報へ変換して返却します。
	 * 
	 * @return ユーザ情報テーブルの全登録情報
	 */
	public List<UserComListInfo>editUserList();
	
	/**
	 * ユーザ情報取得(条件付き)
	 * 
	 * <p>ユーザ情報を条件検索する
	 * 
	 * @param form 入力情報
	 * @return 検索結果
	 */
	public List<UserComListInfo> editUserListByParam(UserSearchInfo dto);
	


}
