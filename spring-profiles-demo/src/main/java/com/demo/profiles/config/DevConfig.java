package com.demo.profiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev") // ← This bean only loads in 'dev' profile
public class DevConfig {

	@Bean
	public String dataSourceInfo() {
		System.out.println("=== DEV CONFIG LOADED: Using H2 In-Memory DB ===");
		return "H2-Dev";
	}
}