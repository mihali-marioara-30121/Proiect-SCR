package com.proiect.scd.proiectSCD;

import com.mailjet.client.errors.MailjetException;
import com.proiect.scd.proiectSCD.service.EmailService;
import com.proiect.scd.proiectSCD.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProiectScdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProiectScdApplication.class, args);
	}

}
