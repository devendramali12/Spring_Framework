package obj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Value(value = "Manga")
	String name;

	@Autowired
	List<String> subjects;

	public void display() {
		System.out.println("-----Student------");
		System.out.println("name : " + name);
		System.out.println("subjects : " + subjects);
	}
}
