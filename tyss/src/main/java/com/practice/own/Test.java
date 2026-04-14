package com.practice.own;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		User user = app.getBean(User.class);
		user.start();
	}
}