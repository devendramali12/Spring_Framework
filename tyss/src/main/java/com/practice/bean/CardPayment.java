package com.practice.bean;

public class CardPayment implements PaymentService {

	@Override
	public void pay() {
		System.out.println("Payment Via Card");
	}

}
