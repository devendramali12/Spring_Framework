package obj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	// @Autowired // Var / Field injection
	
	Engine engine;
	
//	@Autowired
	public Car( @Autowired Engine engine) {
	
		this.engine = engine;
	}

//	@Autowired // Setter Injection
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void speed() {
		engine.start();
		System.out.println("Car is running in 80Km/hr");
	}
	
	

	

	
}
