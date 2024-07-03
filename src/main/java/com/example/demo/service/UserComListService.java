package com.example.demo.service;

import java.util.List;

import com.example.demo.constant.UserDeleteResult;
import com.example.demo.entity.UserListInfo;
import com.example.demo.entity.UserSearchInfo;

public interface UserComListService {
	/**
	 * ユーザ情報テーブルを全件検索し、ユーザ一覧画面に必要な情報へ変換して返却します。
	 * 
	 * @return ユーザ情報テーブルの全登録情報
	 */
	public List<UserListInfo>editUserList();
	
	/**
	 * ユーザ情報取得(条件付き)
	 * 
	 * <p>ユーザ情報を条件検索する
	 * 
	 * @param form 入力情報
	 * @return 検索結果
	 */
	public List<UserListInfo> editUserListByParam(UserSearchInfo dto);
	
	/**
	 * 指定されたIDのユーザ情報を削除します。
	 * 
	 * @param loginId
	 * @return
	 */
	public UserDeleteResult deleteUserInfoById(String loginId);

}
