package com.example.demo.service;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.SignupResult;
import com.example.demo.constant.db.AuthorityKind;
import com.example.demo.constant.db.UserStatusKind;
import com.example.demo.entity.SignupInfo;
import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.service.common.MailSendService;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * ユーザ登録画面 Servie
 * 
 * @author k-murata
 * 
 */

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {
	
	/** メール送信Serviceクラス */
	private final MailSendService mailSendService;
	
	/** ユーザ情報テーブルDAO */
	private final UserInfoRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	/** ワンタイムコードの長さ */
	@Value("${one-time-code.valid-time}")
	private Duration oneTimeCodeValidTime = Duration.ZERO;
	
	/** ワンタイムコードの長さ */
	@Value("${one-time-code.length}")
	private int oneTimeCodeLength = 0;
	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public SignupResult signup(SignupInfo dto) {
		var userInfoOpt = repository.findById(dto.getLoginId());
		if(userInfoOpt.isPresent()) {
			var userInfo = userInfoOpt.get();
			if(userInfo.isSignupCompleted()) {
				return SignupResult.FAILURE_BY_ALREADY_COMPLETED;
			}
			return SignupResult.FAILURE_BY_SIGNUP_PROCEEDING;
		}
		
		var oneTimeCode = generatedRandomString();
		var signupInfo = editSignupInfo(dto,oneTimeCode);
		try {
			repository.save(signupInfo);
		}catch(Exception e) {
			return SignupResult.FAILURE_BY_DB_ERROR;
		}
		
		//ユーザがメール本文からアクセスする本登録用のリンクを作成
		var mailTextBase = AppUtil.getMessage(messageSource, MessageConst.SIGNUP_MAIL_TEXT);
		var mailText = MessageFormat.format(mailTextBase,oneTimeCode,oneTimeCodeValidTime.toMinutes());
		
		var mailSubject = AppUtil.getMessage(messageSource, MessageConst.SIGNUP_MAIL_SUBJECT);
		var canSendMail = mailSendService.sendMail(dto.getMailAddress(),mailSubject,mailText);
		if(!canSendMail) {
			var isDeleteFailure = deleteSignupInfo(dto.getLoginId());
			if(!isDeleteFailure) {
				return SignupResult.FAILURE_BY_DB_ERROR;
			}
			return SignupResult.FAILURE_BY_MAIL_SEND_ERROR;
		}
				
		return SignupResult.SUCCEED;
	}
	
	/**
	 * ユーザ情報テーブル 主キー検索
	 * @param loginId ログインID
	 * @return 登録情報(ユーザ情報Entitiy)
	 */
	public Optional<UserInfo> resistUserInfo(SignupForm form){
		var userInfoExistedOpt = repository.findById(form.getLoginId());
		
		if(userInfoExistedOpt.isPresent()) {
			return Optional.empty();
		}
		
		var userInfo = mapper.map(form, UserInfo.class);
		/**
		 * 時刻の取得
		 * Calendar calendar = Calendar.getInstance();
		 * String time = calendar.getTime().toString();
		 */
		
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		userInfo.setPassword(encodedPassword);
		userInfo.setUserStatusKind(UserStatusKind.ENABLED);
		userInfo.setAuthorityKind(AuthorityKind.ITEM_WATCHER);
		userInfo.setCreateTime(LocalDateTime.now());
		userInfo.setUpdateTime(LocalDateTime.now());
		userInfo.setUpdateUser(form.getLoginId());
		
		return Optional.of(repository.save(userInfo));
	}
	
	/**
	 * ランダムな数字でワンタイムコードを生成します。
	 * 
	 * @return ワンタイムコード
	 */
	private String generatedRandomString() {
		var sb = new StringBuilder();
		for(int i = 0;i<oneTimeCodeLength;i++) {
			var randomNum = ThreadLocalRandom.current().nextInt(10);
			sb.append(randomNum);
		}
		return sb.toString();
	}
	
	/**
	 * ユーザ登録情報を作成する
	 * 
	 * @param dto ユーザ登録画面Service入力情報
	 * @param oneTimeCode ワンタイムコード
	 * @return ユーザ登録情報
	 */
	private UserInfo editSignupInfo(SignupInfo dto,String oneTimeCode) {
		var userInfo = new UserInfo();
		userInfo.setLoginId(dto.getLoginId());
		userInfo.setPassword(passwordEncoder.encode(dto.getPassword()));
		userInfo.setMailAddress(dto.getMailAddress());
		userInfo.setOneTimeCode(passwordEncoder.encode(oneTimeCode));
		userInfo.setOneTimeCodeSendTime(LocalDateTime.now());
		userInfo.setUserStatusKind(UserStatusKind.DISABLED);
		userInfo.setAuthorityKind(AuthorityKind.ITEM_WATCHER);
		userInfo.setSignupCompleted(false);
		userInfo.setCreateTime(LocalDateTime.now());
		userInfo.setUpdateTime(LocalDateTime.now());
		userInfo.setUpdateUser(dto.getLoginId());
		
		return userInfo;
	}
	
	private boolean deleteSignupInfo(String loginId) {
		try {
			repository.deleteById(loginId);
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}

}