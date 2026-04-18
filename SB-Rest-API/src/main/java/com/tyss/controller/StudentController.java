package com.tyss.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/fetch")
	public String fetch() {
		return "Student Fetched";
	}

	@PostMapping("/save")
	public String save() {
		return "Student saved";
	}

	@PutMapping("/update")
	public String update() {
		return "Student updated";
	}

	@DeleteMapping("/delete")
	public String delete() {
		return "Student deleted";
	}

}