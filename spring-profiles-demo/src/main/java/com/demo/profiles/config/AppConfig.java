package com.demo.profiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod") // ← Loads for ALL profiles EXCEPT prod
public class AppConfig {

	@Bean
	public String debugMode() {
		System.out.println("=== DEBUG MODE ENABLED (not prod) ===");
		return "debug-enabled";
	}
}