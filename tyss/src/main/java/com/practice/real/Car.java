package com.practice.real;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	private Engine engine;

	// --> Constructor Injection

	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
	}

	public void carinfo() {
		System.out.println("Car Details");
		engine.engineInfo();
	}

}
