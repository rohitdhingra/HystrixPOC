package com.rohit.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/emailService")
public class EmailServiceApplication {

	@GetMapping("/send")
	public String sendEmail()
	{
		return "Email Service called..";
	}
	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
