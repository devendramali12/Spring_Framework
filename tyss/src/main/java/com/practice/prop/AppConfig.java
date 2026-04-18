package com.practice.prop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.practice.tyss.Mobile;

@Configuration
@ComponentScan("com.practice.prop")
@PropertySource("classpath:app.properties")
public class AppConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer configurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Mobile mobile() { // ✅ THIS IS MISSING
		return new Mobile();
	}
}
