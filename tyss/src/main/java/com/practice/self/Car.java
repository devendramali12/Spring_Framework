package com.practice.self;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Value("Tata")
	String brand;

	@Value("100")
	int price;

	public void info() {
		System.out.println("Field Injection");
		System.out.println("Car Brabd is " + brand + " Value is " + price);
	}
}
