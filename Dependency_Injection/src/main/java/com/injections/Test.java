package com.injections;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee e1 = app.getBean(Employee.class);
		e1.info();

		Laptop l1 = app.getBean(Laptop.class);
		l1.info();

		Person p1 = app.getBean(Person.class);
		p1.display();
	}

}
