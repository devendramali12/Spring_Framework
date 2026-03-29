
package ty;

import org.springframework.stereotype.Component;

@Component(value = "carBean")
public class CAR {

	public void speed() {
		System.out.println("car is running in 60km/hr");
	}
}
