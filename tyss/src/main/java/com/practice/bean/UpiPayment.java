package com.practice.bean;

public class UpiPayment implements PaymentService {

	@Override
	public void pay() {
		System.out.println("Payment Via UPI");
	}

}
