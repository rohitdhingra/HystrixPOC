package com.rohit.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/paytmService")
public class PaytmServiceApplication {

	@GetMapping("/pay")
	public String payNow()
	{
		return "Payment Service called successfully";
	}
	public static void main(String[] args) {
		SpringApplication.run(PaytmServiceApplication.class, args);
	}

}
