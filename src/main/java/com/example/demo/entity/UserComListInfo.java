package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserComListInfo {
	
	/** ログインID */
	@Id
	@Column(name="login_id")
	private String loginId = null;
	
	/** 連絡事項 */
	private String notice = null;
	
	/** 備考 */
	private String note = null;
	
	/** 連絡先 */
	private String contactAddress = null;
	
	/** 作業内容 */
	private String workDetails = null;
	
	/** 作業状況 */
	private String workStatus = null;
	
	/** 連絡確認状況 */
	private boolean isNoticeWatched = true;
}
