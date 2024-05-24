package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザ更新結果メッセージEnumクラス
 * 
 * @author k-murata
 * 
 */

@Getter
@AllArgsConstructor
public enum UserEditMessage {

	/***/
	SUCCEED(MessageConst.USEEDIT_UPDATE_SUCCEED),
	
	/***/
	FAILED(MessageConst.USEREDIT_UPDATE_FAILED);
	
	/***/
	private String messageId;
	
}
