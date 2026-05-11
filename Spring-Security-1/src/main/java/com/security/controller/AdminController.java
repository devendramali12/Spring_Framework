package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	public String createCred() {
		System.out.println("Credentials created for user");
		return "Credentials created for user";
	}

}
