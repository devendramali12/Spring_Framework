package com.injections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	// --> Constructor Injection

	String name;
	String eid;

	public Employee(@Value(value = "Penga") String name, @Value(value = "A101") String eid) {
		this.name = name;
		this.eid = eid;

	}

	public void info() {
		System.out.println("-------Person Data----------");
		System.out.println("Name :- " + name);
		System.out.println("Eid :- " + eid);
	}

}
