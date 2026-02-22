package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentRequest;
import com.example.demo.dto.StudentResponse;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private StudentService studentservice;

	@PostMapping("add")
	public void add(@RequestBody StudentRequest studentrequest) {
		studentservice.add(studentrequest);
	}

	
	@DeleteMapping("delete/{roll}")
	public StudentResponse delete(@PathVariable Integer roll) {

		return studentservice.delete(roll);
	}

	
	@GetMapping("display")
	public List<StudentResponse> display() {

		return studentservice.display();
	}

	
	@PostMapping("add all")
	public void addAll(@RequestBody List<StudentRequest> list) {
		studentservice.addAll(list);
	}

	
	@GetMapping("search/{roll}")
	public ResponseEntity<?> search(@PathVariable Integer roll) {
		Student temp = studentservice.search(roll);
		if (temp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.ok(temp);
	}

	
	@PutMapping("update/{roll}")
	public ResponseEntity<String> update(@PathVariable Integer roll, @RequestBody StudentRequest request) {
		studentservice.update(request, roll);
		return ResponseEntity.ok("Updated Successfully");
	}

}