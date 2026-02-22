package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.TeacherRequest;
import com.example.demo.dto.TeacherResponse;
import com.example.demo.model.Teacher;



public interface TeacherService {

	void add(TeacherRequest teacherrequest);
	
	Teacher search(Integer id);

	List<TeacherResponse> display();

	TeacherResponse delete(Integer id);

	void update(Teacher teacher, Integer id);

	Teacher findByMob(String mob);

	Teacher findByEmail(String email);

	void addAll(List<TeacherRequest> list);

	TeacherResponse update(TeacherRequest request, Integer id);

}