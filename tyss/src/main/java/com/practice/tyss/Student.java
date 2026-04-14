package com.practice.tyss;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	String name;
	int age;

	public Student(@Value("Devendra") String name, @Value("22") int age) {

		this.name = name;
		this.age = age;
	}

	public void info() {
		System.out.println("Student name is " + name);
		System.out.println("Student Age is " + age);
	}

}
