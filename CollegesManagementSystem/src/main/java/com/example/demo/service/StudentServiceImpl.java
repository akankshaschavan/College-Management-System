package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentRequest;
import com.example.demo.dto.StudentResponse;
import com.example.demo.exception.InvalidEmail;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.exception.InvalidRoll;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public void add(StudentRequest studentrequest) {
		// TODO Auto-generated method stub
		
		List<Student> list = studentrepository.findAll();

		String mob = studentrequest.getMob();
		if (mob != null) {
			mob = mob.trim();
		}

		if (mob.length() == 10) {
			if (mob.charAt(0) == '0' || mob.charAt(0) == '1' || mob.charAt(0) == '2' || mob.charAt(0) == '3'
					|| mob.charAt(0) == '5' || mob.charAt(0) == '6') {
				throw new InvalidMobileNumber("Invalid Mobile Number");
			}
		}

		for (int i = 0; i < mob.length(); i++) {
			if (!Character.isDigit(mob.charAt(i))) {
				throw new InvalidMobileNumber("Invalid Number");
			}
		}
		Student existing = studentrepository.findByMob(mob);
		if (existing != null) {
			throw new InvalidMobileNumber("Mobile Number Is Already Exist");
		}

		Integer roll = studentrequest.getRoll();
		if (roll == null || roll < 0) {
			throw new InvalidRoll("Roll Must Be Positive");
		}

		for (Student stud : list) {
			if (stud.getRoll().equals(roll)) {
				throw new InvalidRoll("Roll Number Is Already exist");
			}
		}

		
		String email = studentrequest.getEmail();
		for (Student stud : list) {
			if (email != null && email.equals(stud.getEmail())) {
				throw new InvalidEmail("Email Is Already Exist");
			}
		}
		Student std = StudentRequest.toEntity(studentrequest);
		studentrepository.save(std);
	}
		


	@Override
	public List<StudentResponse> display() {
		// TODO Auto-generated method stub
		
		List<Student> students = studentrepository.findAll();

		List<StudentResponse> studresp = new ArrayList<>();
		for (Student student : students) {

			StudentResponse response = new StudentResponse();

			response.setRoll(student.getRoll());
			response.setName(student.getName());
			response.setDiv(student.getDiv());
			response.setYear(student.getYear());
			response.setEmail(student.getEmail());
			response.setMarks(student.getMarks());
			response.setMob(student.getMob());

			studresp.add(response);
		}
		return studresp;

	}
	
	

	@Override
	public StudentResponse delete(Integer roll) {
		// TODO Auto-generated method stub
		
		if (studentrepository.findById(roll).isPresent()) {
			Student temp = studentrepository.findById(roll).get();
			studentrepository.delete(temp);
			return StudentResponse.toDTO(temp);
		}

		return null;
	}

	
	@Override
	public StudentResponse update(StudentRequest request, Integer roll) {
		// TODO Auto-generated method stub
		
		Student student = studentrepository.findById(roll).get();
		if (student == null) {
			throw new InvalidRoll("Invalid Roll id");
		}
		student.setName(request.getName());
		student.setDiv(request.getDiv());
		student.setEmail(request.getEmail());
		student.setMarks(request.getMarks());
		student.setMob(request.getMob());
		Student updatedStudent = studentrepository.save(student);
		return StudentResponse.toDTO(updatedStudent);

	
	}

	@Override
	public boolean existsByMob(String mob) {
		// TODO Auto-generated method stub
	

		return false;
	}

	@Override
	public boolean findByMob(String mob) {
		// TODO Auto-generated method stub
		return studentrepository.findByMob(mob) != null;
	}

	
	@Override
	public Student search(Integer roll) {
		// TODO Auto-generated method stub
		
		if (studentrepository.findById(roll).isPresent()) {
			Student temp = studentrepository.findById(roll).get();
			return temp;
		}
		return null;
	}
	
	
	@Override
	public void addAll(List<StudentRequest> list) {
		// TODO Auto-generated method stub
		
		List<Student> students = list.stream().map(StudentRequest::toEntity).toList();
		studentrepository.saveAll(students);
	}
		
}