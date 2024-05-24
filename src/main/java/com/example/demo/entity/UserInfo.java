package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.constant.db.AuthorityKind;
import com.example.demo.constant.db.UserStatusKind;
import com.example.demo.converter.UserAuthorityConverter;
import com.example.demo.converter.UserStatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザ情報テーブル Entity
 * 
 * @author k-murata
 * 
 */

@Entity
//SQLのテーブル名
@Table(name="user_infomation")
@Data
@AllArgsConstructor
public class UserInfo {

	/** ログインID */
	@Id
	@Column(name="login_id")
	private String loginId = null;
	
	/** パスワード */
	private String password = null;
	
	/** メールアドレス */
	@Column(name = "mail_address")
	private String mailAddress;
	
	/** ワンタイムコード */
	@Column(name = "one_time_code")
	private String oneTimeCode;
	
	/** ワンタイムコード有効期限 */
	@Column(name = "one_time_code_send_time")
	private LocalDateTime oneTimeCodeSendTime;
	
	/** 契約日時 */
	@Column(name="contract_time")
	private LocalDateTime contract_time;
	
	/** ログイン失敗回数 */
	@Column(name = "login_failure_count")
	private int loginFailureCount=0;

	@Column(name = "account_locked_time")
	private LocalDateTime accountLockedTime;
	
	/** ユーザ状態種別 */
	@Column(name = "is_disabled")
	@Convert(converter = UserStatusConverter.class)
	private UserStatusKind userStatusKind;
	
	/** ユーザ権限種別 */
	@Column(name = "authority")
	@Convert(converter = UserAuthorityConverter.class)
	private AuthorityKind authorityKind;
	
	/** 登録日時 */
	@Column(name="create_time")
	private LocalDateTime createTime;
	
	/** 最終更新日時 */
	@Column(name="update_time")
	private LocalDateTime updateTime;
	
	/** 最終更新ユーザ */
	@Column(name="update_user")
	private String updateUser;
	
	public UserInfo() {
	}
	
	/**
	 * ログイン失敗回数をインクリメントする
	 * 
	 * @return ログイン失敗回数がインクリメントされたUserInfo
	 * 
	 */
	public UserInfo incrementLoginFailureCount() {
		return new UserInfo(loginId,password,mailAddress,oneTimeCode,oneTimeCodeSendTime,contract_time,++loginFailureCount,accountLockedTime,userStatusKind,authorityKind,createTime,updateTime,updateUser);
	}
	
	/**
	 * ログイン失敗情報をリセットする
	 * 
	 * @return ログイン失敗情報がリセットされたUserInfo
	 */
	public UserInfo resetLoginFailureInfo() {
		return new UserInfo(loginId,password,mailAddress,oneTimeCode,oneTimeCodeSendTime,contract_time,0,null,userStatusKind,authorityKind,createTime,updateTime,updateUser);
	}
	
	/**
	 * アカウントロック状態に更新する
	 * 
	 * @return ログイン失敗回数、アカウントロック日時が更新されたUserInfo
	 */
	public UserInfo updateAccountLocked() {
		return new UserInfo(loginId,password,mailAddress,oneTimeCode,oneTimeCodeSendTime,contract_time,0,LocalDateTime.now(),userStatusKind,authorityKind,createTime,updateTime,updateUser);
	}
	
	/**
	 * 契約日時を更新する
	 * 
	 * @return 契約日時が更新されたUserInfo
	 */
	public UserInfo completeContract() {
		return new UserInfo(loginId,password,mailAddress,oneTimeCode,oneTimeCodeSendTime,LocalDateTime.now(),loginFailureCount,accountLockedTime,userStatusKind,authorityKind,createTime,updateTime,updateUser);
	}
}
