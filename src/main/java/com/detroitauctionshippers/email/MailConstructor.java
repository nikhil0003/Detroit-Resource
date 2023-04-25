package com.detroitauctionshippers.email;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.detroitauctionshippers.pojo.EmailTemplate;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailConstructor {
	@Autowired
	private Environment env;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	
	public MimeMessagePreparator constructEstimateEmail (EmailTemplate emailTemplate, Locale locale) {
		Context context = new Context();
		context.setVariable("emailTemplate", emailTemplate);
		String text = templateEngine.process("estimate", context);
		System.out.println(text);
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				email.setTo("mail2nikhilkumar3@gmail.com");
				email.setSubject("dumouchelles auction pickup and delivery");
				email.setText(text, true);
				email.setFrom(new InternetAddress("arenelliyadagiri@outlook.com"));
			}
		};
		
		return messagePreparator;
	}
	

}
