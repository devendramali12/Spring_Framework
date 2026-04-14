package com.practice.self;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Watch {

	String brand;
	int price;

	@Value("Titan")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Value("250")
	public void setPrice(int price) {
		this.price = price;
	}

	public void info() {
		System.out.println("Setter Injection");
		System.out.println("Watch Brand is " + brand + " Price is " + price);
	}

}
