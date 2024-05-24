package com.example.demo.service;

import java.util.Optional;

import com.example.demo.constant.UserEditResult;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserUpdateInfo;

public interface UserEditService {
	
	public Optional<UserInfo> searchUserInfo(String loginId);
	
	public UserEditResult updateUserInfo(UserUpdateInfo userUpdateInfo);
	
	

}
