package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserComListInfo;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserSearchInfo;
import com.example.demo.repository.UserInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserComListServiceImpl implements UserComListService {

	/** ユーザ情報テーブルDAO */
	private final UserInfoRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserComListInfo> editUserList() {
		return toUserComListInfos(repository.findAll());
	}
	
	public List<UserComListInfo> toUserComListInfos(List<UserInfo> userInfos){
		var userListInfos=new ArrayList<UserComListInfo>();
		for(UserInfo userInfo : userInfos) {
			var userListInfo = mapper.map(userInfo, UserComListInfo.class);
//			userListInfo.setNotice(userInfo.getUserStatusKind().getDisplayValue());
//			userListInfo.setContractTime(userInfo.getContract_time());
//			userListInfo.setAuthorityKind(userInfo.getAuthorityKind().getDisplayValue());
			userListInfos.add(userListInfo);
		}
		return userListInfos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserComListInfo> editUserListByParam(UserSearchInfo dto) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
