package com.alkemyApi.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	
	public void sendSimpleEmail(String toEmail,String body,String subjet) {
		
		SimpleMailMessage message= new SimpleMailMessage();
		
		message.setFrom("feeedeee2020@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subjet);
		
		mailSender.send(message);
		System.out.println("Mail send...");
		
		
	}
}
