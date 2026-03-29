package di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	private String brand;
	private double price;
	
	@Value (value ="HP")
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Value (value="50000")
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void display() {
		System.out.println("----Laptop----");
		System.out.println("Brand : " + brand);
		System.out.println("Price : " + price);
		
	}
	
	
	

}
