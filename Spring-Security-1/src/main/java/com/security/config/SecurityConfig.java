package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public SecurityFilterChain filterChain(HttpSecurity http) {
		http.csrf(c -> c.disable())
				.authorizeHttpRequests(req -> req.requestMatchers("/auth/**").permitAll().requestMatchers("/admin/**")
						.hasRole("ADMIN").requestMatchers("/user/**").hasRole("USER").anyRequest().authenticated())
				.formLogin(Customizer.withDefaults());// UsernameAndPasswordAuthenticationFilter

		return http.build();
	}

	@Bean
	public UserDetailsService detailsService() {

		UserDetails u1 = User.withUsername("manga").password("{noop}manga@123").roles("USER").build();

		UserDetails u2 = User.withUsername("mangi").password("{noop}mangi@123").roles("ADMIN").build();

		UserDetails u3 = User.withUsername("penga").password("{noop}penga@123").roles("USER", "ADMIN").build();

		return new InMemoryUserDetailsManager(u1, u2, u3);
	}

}
