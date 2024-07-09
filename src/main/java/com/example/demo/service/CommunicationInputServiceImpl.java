package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserComListInfo;
import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunicationInputServiceImpl implements CommunicationInputService {

	/** ユーザ情報テーブルDAO */
	private final UserInfoRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<UserInfo> serchUserById(String userInfo) {
		// TODO 自動生成されたメソッド・スタブ
		return Optional.empty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setContactAddress(String address) {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCom(UserComListInfo userComListInfos) {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSubmissonDay(UserComListInfo userComListInfos) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSubmissonWeek(UserComListInfo userComListInfos) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSubmissonMonth(UserComListInfo userComListInfos) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
