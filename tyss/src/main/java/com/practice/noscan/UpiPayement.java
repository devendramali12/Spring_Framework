package com.practice.noscan;

public class UpiPayement implements PaymentService {

	@Override
	public void pay() {
		System.out.println("Payment Using UPI");
	}

}
