package com.injections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	// --> Setter Injection

	private String brand;
	private String price;

	@Value(value = "Hp")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Value(value = "5000")
	public void setPrice(String price) {
		this.price = price;
	}

	public void info() {
		System.out.println("------------laptop------------");
		System.out.println("Brand :-" + brand);
		System.out.println("Price :- " + price);
	}

}
