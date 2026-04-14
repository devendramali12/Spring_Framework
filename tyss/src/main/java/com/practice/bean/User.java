package com.practice.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

	private PaymentService paymentservice;

	@Autowired
	public User(PaymentService paymentService) {
		this.paymentservice = paymentService;

	}

	public void makePayment() {
		paymentservice.pay();
	}

}
