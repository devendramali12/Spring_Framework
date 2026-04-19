package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("students", service.getAllStudents());

		return "index";
	}

	@GetMapping("/add")
	public String addForm() {

		return "addStudent";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student, Model model) {

		boolean saved = service.saveStudent(student);

		if (!saved) {

			model.addAttribute("error", "Student ID already exists!");

			return "addStudent";
		}

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable int id, Model model) {

		model.addAttribute("student", service.getStudentById(id));

		return "editStudent";
	}

	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student) {

		service.updateStudent(student);

		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {

		service.deleteStudent(id);

		return "redirect:/";
	}

}