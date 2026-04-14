package com.practice.tyss;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {

		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(App.class);

		System.out.println("Learning Dependency Injection");
		Employee employee = app.getBean(Employee.class);
		employee.read();

		System.out.println("----------------------------------------------------------");

		Student student = app.getBean(Student.class);
		student.info();

		System.out.println("----------------------------------------------------------");

		Mobile mobile = app.getBean(Mobile.class);
		mobile.display();

		System.out.println("------ Field Injection ------");
		Earphones earphone = app.getBean(Earphones.class);
		earphone.info();

	}
}