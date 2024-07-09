package com.example.demo.service;

import java.util.Objects;
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
		return repository.findById(userInfo);
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
		
		/** boolean判定変数 */
		boolean isDay = false;
		
		if(Objects.isNull(userComListInfos.getSubmissonDay())) {
			isDay = true;
		}
		
		return isDay;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSubmissonWeek(UserComListInfo userComListInfos) {

		/** boolean判定変数 */
		boolean isWeek = false;
		
		if(Objects.isNull(userComListInfos.getSubmissonWeek())) {
			isWeek = true;
		}
		
		return isWeek;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSubmissonMonth(UserComListInfo userComListInfos) {
		
		/** boolean判定変数 */
		boolean isMonth = false;
		
		if(Objects.isNull(userComListInfos.getSubmissonMonth())) {
			isMonth = true;
		}
		
		return isMonth;
	}

}
