package obj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	@Value (value = "Manga")
	String name;
	
//	@Autowired
//	@Qualifier (value= "Samsung")
	Mobile mobile;

	
	@Autowired
//	@Qualifier (value ="samsung") // CTE
	public Person(@Qualifier("samsung") Mobile mobile) {
		this.mobile = mobile;
	}
	public void usingMobile() {
		System.out.println(name + " is using mobile");
		mobile.call();
	}
}
