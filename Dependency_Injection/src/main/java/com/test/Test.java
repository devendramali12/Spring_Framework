package com.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.main.AppConfig;

public class Test {
	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Student student = app.getBean(Student.class);
		student.read();

		UserDetails ud = app.getBean(UserDetails.class);
		ud.profile();

		Car c1 = app.getBean(Car.class);
		c1.speed();
	}
}
