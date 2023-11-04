package com.proiect.scd.proiectSCD;

import com.mailjet.client.errors.MailjetException;
import com.proiect.scd.proiectSCD.service.EmailService;
import com.proiect.scd.proiectSCD.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProiectScdApplication {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) throws MailjetException {
		SpringApplication.run(ProiectScdApplication.class, args);
		//EmailServiceImpl emailService1 = new EmailServiceImpl();
		//emailService1.sendEmail(null);
	}

}
