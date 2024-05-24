package com.example.demo.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailSendService{

	/** メール送信用クラス */
	private final MailSender mailSender;
	
	public boolean sendMail(String mailTo,String mailSubject,String mailText) {
		var smm = new SimpleMailMessage();
		smm.setTo(mailTo);
		smm.setSubject(mailSubject);
		smm.setText(mailText);
		
		try {
			mailSender.send(smm);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
