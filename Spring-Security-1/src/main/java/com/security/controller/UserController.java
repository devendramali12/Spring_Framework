package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/save")
	public String home() {
		System.out.println("User Saved");
		return "User Saved";
	}

	@GetMapping("/update")
	public String userupdate() {
		System.out.println("User Updated");
		return "User Updated";
	}

}
