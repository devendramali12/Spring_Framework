package com.practice.noscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public PaymentService paymentService() {
		return new UpiPayement(); // --> manually created
	}

	@Bean
	public User user() {
		return new User(paymentService()); // dependency injected manually
	}
}
