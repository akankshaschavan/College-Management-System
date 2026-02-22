package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TeacherRequest;
import com.example.demo.dto.TeacherResponse;
import com.example.demo.exception.InvalidEmail;
import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherrepository;

    @Override
    public void add(TeacherRequest teacherRequest) {
        List<Teacher> list = teacherrepository.findAll();

        String mob = teacherRequest.getMob();
        if (mob != null) mob = mob.trim();

        if (mob.length() == 10 && mob.charAt(0) >= '0' && mob.charAt(0) <= '5') {
            throw new InvalidMobileNumber("Mobile Number cannot start with 0-5");
        }

        for (int i = 0; i < mob.length(); i++) {
            if (!Character.isDigit(mob.charAt(i))) throw new InvalidMobileNumber("Invalid Mobile Number");
        }

        if (teacherrepository.findByMob(mob) != null) {
            throw new InvalidMobileNumber("Mobile Already Exists");
        }

        Integer id = teacherRequest.getId();
        if (id == null || id <= 0) throw new InvalidId("Id Must Be Positive");

        for (Teacher t : list) {
            if (t.getId().equals(id)) throw new InvalidId("Id Already Exists");
        }

        String email = teacherRequest.getEmail();
        if (email == null) throw new InvalidEmail("Email Required");

        if (teacherrepository.findByEmail(email) != null) throw new InvalidEmail("Email Already Exists");

        Teacher teacher = TeacherRequest.toEntity(teacherRequest);
        teacherrepository.save(teacher);
    }

    
    @Override
    public List<TeacherResponse> display() {
        List<Teacher> teachers = teacherrepository.findAll();
        List<TeacherResponse> responseList = new ArrayList<>();

        for (Teacher t : teachers) {
            responseList.add(TeacherResponse.toDTO(t));
        }

        return responseList;
    }
    

    @Override
    public TeacherResponse delete(Integer id) {
        Teacher t = teacherrepository.findById(id).orElse(null);
        if (t != null) {
            teacherrepository.delete(t);
            return TeacherResponse.toDTO(t);
        }
        return null;
    }

    
    @Override
    public Teacher findByMob(String mob) {
        return teacherrepository.findByMob(mob);
    }

    
    @Override
    public Teacher findByEmail(String email) {
        return teacherrepository.findByEmail(email);
    }

    
    @Override
    public void addAll(List<TeacherRequest> list) {
        List<Teacher> teachers = list.stream().map(TeacherRequest::toEntity).toList();
        teacherrepository.saveAll(teachers);
    }
    

    @Override
    public TeacherResponse update(TeacherRequest request, Integer id) {
        Teacher existingTeacher = teacherrepository.findById(id)
                .orElseThrow(() -> new InvalidId("Invalid Id"));

        existingTeacher.setName(request.getName());
        existingTeacher.setEmail(request.getEmail());
        existingTeacher.setMob(request.getMob());

        Teacher updatedTeacher = teacherrepository.save(existingTeacher);
        return TeacherResponse.toDTO(updatedTeacher);
    }

    
	@Override
	public void update(Teacher teacher, Integer id) {
		// TODO Auto-generated method stub
		teacher.setId(id);
		teacherrepository.save(teacher);

		
	}

    @Override
	public Teacher search(Integer id) {
		return teacherrepository.findById(id).orElse(null);
	}
	
}