package com.injections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	// --> Variable / Field Injection

	@Value(value = "Devendra")
	String name;

	@Value(value = "22")
	int age;

	public void display() {
		System.out.println("-------------- Person --------------");
		System.out.println("Name :- " + name);
		System.out.println("Age :- " + age);
	}
}
