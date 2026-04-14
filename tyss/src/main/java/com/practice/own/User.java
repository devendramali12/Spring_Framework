package com.practice.own;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
	private MobileBrand mobileBrand;;

	@Autowired
	public User(MobileBrand mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public void start() {
		mobileBrand.call();
		mobileBrand.msg();

	}

}
