package com.rohit.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@RequestMapping("/bookmyshowService")
@EnableHystrix
@EnableHystrixDashboard
public class BookMyShowServiceApplication {

	@Autowired
	private RestTemplate template;
	
	@HystrixCommand(groupKey = "jmd",commandKey = "jmd",fallbackMethod = "bookMyShowFallback")
	@GetMapping("/book")
	public String bookShow() {
		
		String emailServiceResponse = template.getForObject("http://localhost:8081/emailService/send", String.class);
		String paytmServiceResponse = template.getForObject("http://localhost:8082/paytmService/pay", String.class);
		
		
		return "Completed Successfully with:"+emailServiceResponse+"  \n and payment response:"+paytmServiceResponse;
	}
	public String bookMyShowFallback()
	{
		return "service gateway failed";
	}
	public static void main(String[] args) {
		SpringApplication.run(BookMyShowServiceApplication.class, args);
	}
	@Bean
	public RestTemplate template()
	{
		return new RestTemplate();
	}

}
