package di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// --> Constructor Injection
@Component
public class Employee {

	String name;
	String eid;
	
	
	public Employee(@Value (value="Penga") String name,
			@Value (value ="XYZ101")String eid) {
		
		this.name = name;
		this.eid = eid;
	}
	public void display() {
		System.out.println("-----Employee-----");
		System.out.println("Name : " + name);
		System.out.println("Eid : " + eid);
	}
	
	
}
