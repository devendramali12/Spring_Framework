package com.practice.tyss;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Earphones {

	@Value("OnePlus Nods")
	String brand;

	@Value("2000")
	int price;

	public void info() {
		System.out.println("Earphone brand is :- " + brand + " Price is " + price);
	}

}
