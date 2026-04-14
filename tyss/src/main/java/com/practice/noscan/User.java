package com.practice.noscan;

public class User {
	private PaymentService payemnetService;

	// --> Constructor Injection
	public User(PaymentService paymentService) {
		this.payemnetService = paymentService;
	}

	public void makePayment() {
		payemnetService.pay();
	}

}
