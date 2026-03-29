package di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value (value="manga")
	String name;
	
	@Value (value ="24")
	int age;
	
	public void display() {
		System.out.println("-----Person-----");
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
	}
	
	
}
