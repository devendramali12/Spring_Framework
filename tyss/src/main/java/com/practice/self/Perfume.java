package com.practice.self;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Perfume {

	String brand;
	int price;

	public Perfume(@Value("FOGG") String brand, @Value("200") int price) {

		this.brand = brand;
		this.price = price;
	}

	public void info() {
		System.out.println("Constructor Injection");
		System.out.println("Perfume Brand is " + brand + " Price is " + price);
	}

}
