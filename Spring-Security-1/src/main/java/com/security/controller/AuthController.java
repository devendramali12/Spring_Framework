package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/greet")
	public String grret() {
		System.out.println("Good Afternoon");
		return "Good Afternoon";
	}

	@GetMapping("/register")
	public String register() {
		System.out.println("This is register Aoi");
		return "This is Register Api";
	}
}
