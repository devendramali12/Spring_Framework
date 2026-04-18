package com.practice.prop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Mobile m = app.getBean(Mobile.class);
		m.show();
	}

}
