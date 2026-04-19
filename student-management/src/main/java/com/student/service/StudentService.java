package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;

	// Prevent duplicate ID
	public boolean saveStudent(Student student) {

		if (repo.existsById(student.getId())) {

			return false;
		}

		repo.save(student);

		return true;
	}

	// Used for update
	public void updateStudent(Student student) {

		repo.save(student);
	}

	public List<Student> getAllStudents() {

		return repo.findAll();
	}

	public Student getStudentById(int id) {

		return repo.findById(id).get();
	}

	public void deleteStudent(int id) {

		repo.deleteById(id);
	}

}