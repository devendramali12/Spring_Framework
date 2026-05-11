package com.demo.profiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod") // ← Only loads in 'prod' profile
public class ProdConfig {

	@Bean
	public String dataSourceInfo() {
		System.out.println("=== PROD CONFIG LOADED: Using PostgreSQL ===");
		return "PostgreSQL-Prod";
	}
}