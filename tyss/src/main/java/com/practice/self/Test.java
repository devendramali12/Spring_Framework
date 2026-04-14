package com.practice.self;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		Car car = app.getBean(Car.class);
		car.info();

		System.out.println("----------------------------------------");

		Perfume perfume = app.getBean(Perfume.class);
		perfume.info();

		System.out.println("----------------------------------------");

		Watch watch = app.getBean(Watch.class);
		watch.info();

	}

}
