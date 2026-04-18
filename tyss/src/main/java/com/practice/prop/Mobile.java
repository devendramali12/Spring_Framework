package com.practice.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

	@Value("${mobile.brand}")
	private String brand;

	@Value("${mobile.price}")
	private int price;

	public void show() {
		System.out.println("Brand " + brand);
		System.out.println("Price " + price);
	}
}
