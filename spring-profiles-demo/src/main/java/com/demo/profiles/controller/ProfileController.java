package com.demo.profiles.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.profiles.service.MessageService;

@RestController
@RequestMapping("/api")
public class ProfileController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private Environment environment; // Spring's Environment to check profiles

	@GetMapping("/info")
	public Map<String, String> getInfo() {
		Map<String, String> info = new HashMap<>();
		info.put("message", messageService.getMessage());
		info.put("appInfo", messageService.getAppInfo());
		info.put("activeProfiles", String.join(", ", environment.getActiveProfiles()));
		return info;
	}

	@GetMapping("/profiles")
	public String[] getActiveProfiles() {
		return environment.getActiveProfiles(); // shows which profile is running
	}
}
