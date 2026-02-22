package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.StudentRequest;
import com.example.demo.dto.StudentResponse;
import com.example.demo.model.Student;


public interface StudentService {

	void add(StudentRequest studentrequest);

	List<StudentResponse> display();

	StudentResponse delete(Integer roll);

	StudentResponse update(StudentRequest request, Integer roll);

	boolean existsByMob(String mob);

	boolean findByMob(String mob);

	Student search(Integer roll);

	void addAll(List<StudentRequest> list);

}