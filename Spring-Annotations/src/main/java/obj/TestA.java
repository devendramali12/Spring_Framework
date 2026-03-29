package obj;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestA {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = 
new AnnotationConfigApplicationContext(Config.class);

		Student student = app.getBean(Student.class);
		student.display();

		Movie m = app.getBean(Movie.class);
		m.story();

	}
}