package com.practice.tyss;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

	private int price;
	private String brand;

	public int getPrice() {
		return price;
	}

	@Value("5000")
	public void setPrice(int price) {
		this.price = price;
	}

	@Value("Samsung")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void display() {
		System.out.println("Mobile Brand :- " + brand);
		System.out.println("Mobile Price :- " + price);
	}

}
