package obj;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "obj")
public class Config {
	@Bean
	public List<String> getList() {
		return Arrays.asList("JAVA", "SPRING", "HIBERNATE");
	}

	@Bean(value = "movie")
	public Movie getMovie() {
		return new Movie();

}
	}
