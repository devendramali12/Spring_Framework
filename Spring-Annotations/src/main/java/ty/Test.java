package ty;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Student student = (Student) app.getBean("student");
		student.read();

		UserDetails ud = (UserDetails) app.getBean("userDetails");
		ud.profile();

		CAR c = (CAR) app.getBean("carBean");
		c.speed();

		System.out.println("---------------------");

		Student stud = app.getBean(Student.class);
		stud.read();

		UserDetails userDetails = app.getBean(UserDetails.class);
		userDetails.profile();

		CAR car = app.getBean(CAR.class);
		car.speed();
	}
}
