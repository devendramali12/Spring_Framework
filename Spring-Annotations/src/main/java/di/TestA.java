package di;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestA {
	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(Appconfig.class);
		
		 Employee e =app.getBean(Employee.class);
		 e.display();
		 
		 Laptop l = app.getBean(Laptop.class);
		 l.display();
		 
		 Person p = app.getBean(Person.class);
		 p.display();
		 
		 app.close();
	}

}
