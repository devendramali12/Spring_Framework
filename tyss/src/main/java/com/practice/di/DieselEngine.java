package com.practice.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class DieselEngine implements Engine {

	@Override
	public void start() {
		System.out.println("Diesel Engine Started");
	}
}
