package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.constant.UserDeleteResult;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserListInfo;
import com.example.demo.entity.UserSearchInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserListServiceImpl implements UserListService{

	/** ユーザ情報テーブルDAO */
	private final UserInfoRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserListInfo> editUserList(){
		return toUserListInfos(repository.findAll());
	}
	
	public List<UserListInfo> toUserListInfos(List<UserInfo> userInfos) {
		var userListInfos=new ArrayList<UserListInfo>();
		for(UserInfo userInfo : userInfos) {
			var userListInfo = mapper.map(userInfo, UserListInfo.class);
			userListInfo.setUserStatusKind(userInfo.getUserStatusKind().getDisplayValue());
			userListInfo.setContractTime(userInfo.getContract_time());
			userListInfo.setAuthorityKind(userInfo.getAuthorityKind().getDisplayValue());
			userListInfos.add(userListInfo);
		}
		return userListInfos;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserListInfo> editUserListByParam(UserSearchInfo dto) {
		return toUserListInfos(findUserInfoByParam(dto));
	}
	
	/**
	 * ユーザ情報取得(条件付き)
	 * 
	 * <p>ユーザ情報を条件検索する
	 * 
	 * @param userInfo 入力情報
	 * @return 検索結果
	 */
	private List<UserInfo> findUserInfoByParam(UserSearchInfo dto) {
		var loginIdParam = AppUtil.addWildcard(dto.getLoginId());
		
		if(dto.getUserStatusKind()!=null&&dto.getAuthorityKind()!=null) {
			return repository.findByLoginIdLikeAndUserStatusKindAndAuthorityKind(loginIdParam,
					dto.getUserStatusKind(),dto.getAuthorityKind());
		}else if(dto.getUserStatusKind()!=null) {
			return repository.findByLoginIdLikeAndUserStatusKind(loginIdParam,dto.getUserStatusKind());
		}else if(dto.getAuthorityKind()!=null) {
			return repository.findByLoginIdLikeAndAuthorityKind(loginIdParam,dto.getAuthorityKind());
		}else {
			return repository.findByLoginIdLike(loginIdParam);
		}

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDeleteResult deleteUserInfoById(String loginId) {
		var userInfo = repository.findById(loginId);
		if(userInfo.isEmpty()) {
			return UserDeleteResult.ERROR;
		}
		
		repository.deleteById(loginId);
		
		return UserDeleteResult.SUCCEED;
	}
}
