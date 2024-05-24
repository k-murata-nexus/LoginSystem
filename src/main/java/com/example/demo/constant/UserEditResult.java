package com.example.demo.constant;

import com.example.demo.entity.UserInfo;

import lombok.Data;

@Data
public class UserEditResult {

	private UserEditMessage updateMessage;
	
	private UserInfo updateUserInfo;
}
