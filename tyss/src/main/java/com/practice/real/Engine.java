package com.practice.real;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

	@Value("V8")
	private String type;

	@Value("5000")
	private int horsepower;

	public void engineInfo() {
		System.out.println("Engine Type :- " + type);
		System.out.println("HorsePower :- " + horsepower);
	}
}
