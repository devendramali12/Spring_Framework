package com.practice.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.practice.bean")
public class AppConfig {

	@Bean
	public PaymentService paymentservice() {
		String type = "upi"; // --> imagine coming from config/db

		if (type.equalsIgnoreCase("upi")) {
			return new UpiPayment();
		} else {
			return new CardPayment();
		}
	}

}
