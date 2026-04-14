package com.practice.own;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class Samsung implements MobileBrand {

	@Override
	public void call() {
		System.out.println("Calling From Samsung Mobile");

	}

	@Override
	public void msg() {
		System.out.println("Texting From Samsumg Mobile");

	}

}
