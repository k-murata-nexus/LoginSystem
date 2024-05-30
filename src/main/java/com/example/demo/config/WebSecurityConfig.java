package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.constant.UrlConst;

import lombok.RequiredArgsConstructor;

/**
 * Spring Securityカスタマイズ用
 * 
 * @author k-murata
 * 
 */


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

	/** パスワードエンコーダ */
	private final PasswordEncoder passwordEncoder;
	
	/** ユーザ情報取得Service */
	private final UserDetailsService userDetailsService;

	/** メッセージ取得 */	
	private final MessageSource messageSource;

	/** ユーザ名：ユーザID */
	private final String USERNAME_PARAMETER = "loginId";
	
	/**
	 * Spring Securityの隠すカスタマイズを行います。
	 * 
	 * <p>カスタマイズ設定するのは、以下の項目になります。
	 * <ul>
	 * <li>認証不要URL</li>
	 * <li>ログイン画面のURL</li>
	 * <li>usernameとして利用するリクエストパラメータ名</li>
	 * <li>ログイン成功時のリダイレクト先URL</li>
	 * </ul>
	 * @param http セキュリティ設定
	 * @return カスタマイズ結果
	 * @throws Exception 予期せぬ例外が発生した場合
	 */
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		
		http
			.authorizeHttpRequests(
					authorize -> authorize.requestMatchers(UrlConst.NO_AUTHENTICATION).permitAll()
					.anyRequest().authenticated())
			.formLogin(
					login -> login.loginPage(UrlConst.LOGIN)
							.usernameParameter(USERNAME_PARAMETER)
							.defaultSuccessUrl(UrlConst.MENU))
			.logout(logout -> logout.logoutSuccessUrl(UrlConst.LOGIN));
		
		return http.build();
	}
	
	@Bean
	AuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		provider.setMessageSource(messageSource);
		
		return provider;
	}
}
