package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DetailInfo;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailedService {

	/** ユーザ情報テーブルDAO */
	private final UserInfoRepository repository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void detail(DetailInfo dto) {
		var updateInfoOpt = repository.findById(dto.getLoginId());
		var updateInfo = updateInfoOpt.get();
		updateInfo.setCompanyName(dto.getCompanyName());
		updateInfo.setCompanyAddress(dto.getCompanyAddress());
		updateInfo.setTelephoneNumber(dto.getTelephoneNumber());
		try {
			repository.save(updateInfo);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
