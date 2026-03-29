package obj;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
public static void main(String[] args) {
	ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(Config.class);
	
//	Car c = app.getBean(Car.class);
//	c.speed();
	
	Person p = app.getBean(Person.class);
	p.usingMobile();
	
}
}
