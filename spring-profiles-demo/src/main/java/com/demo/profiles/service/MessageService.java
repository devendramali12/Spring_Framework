package com.demo.profiles.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Value("${app.message}") // reads from active profile's properties
	private String message;

	@Value("${app.name}")
	private String appName;

	@Value("${spring.profiles.active}")
	private String activeProfile;

	public String getMessage() {
		return message;
	}

	public String getAppInfo() {
		return "App: " + appName + " | Active Profile: " + activeProfile;
	}
}
