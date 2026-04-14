package com.practice.di;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class PetrolEngine implements Engine {

	@Override
	public void start() {
		System.out.println("Petrol Engine Started");
	}

}
