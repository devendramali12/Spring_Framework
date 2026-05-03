package com.tyss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/exc")
	public String exc() {

		System.out.println("Welcome to test");

		int a = 10 / 0;// ArithmeticException

		System.out.println("Helloooo");

		return "Welcome to API";
	}
}