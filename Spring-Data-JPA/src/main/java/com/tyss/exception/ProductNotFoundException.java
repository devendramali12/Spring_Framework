package com.tyss.exception;

public class ProductNotFoundException extends RuntimeException {

	private String message;

	public ProductNotFoundException() {

	}

	public ProductNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}