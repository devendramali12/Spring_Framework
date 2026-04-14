package com.practice.own;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Apple implements MobileBrand {

	@Override
	public void call() {
		System.out.println("Calling From Apple Phone");

	}

	@Override
	public void msg() {
		System.out.println("Texting From Iphone");

	}

}
