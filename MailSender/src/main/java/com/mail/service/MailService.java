package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public String sendMail(String toEmail) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("d.yagnesh555@gmail.com");
		mail.setTo(toEmail);
		mail.setSubject("sai");
		mail.setText(("congrats on completeing it on !!"));
		
		javaMailSender.send(mail);
		return "Mail sent Succesful";
	}
}
