package com.example.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * アプリケーション共通クラス
 * 
 * @author k-murata
 * 
 */
public class AppUtil {
	
	/**
	 * メッセージIDからメッセージを取得する
	 * 
	 * @param messageSource メッセージソース
	 * @param key メッセージキー
	 * @param params 置換文字群
	 * @return メッセージ
	 */
	public static String getMessages(MessageSource messageSource,String key,Object... params) {
		return messageSource.getMessage(key,params,Locale.JAPAN);
	}
	
	/**
	 * DBのLIKE検索用に、パラメータにワイルドカードを付与します。
	 * 
	 * @param param パラメータ
	 * @return 前後にワイルドカードが付いたパラメータ
	 */
	public static String addWildcard(String param) {
		return "%"+param+"%";
	}

	public static String doRedirect(String url) {
		return "redirect:"+url;
	}

	public static String getMessage(MessageSource messageSource, Object messageId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
}
