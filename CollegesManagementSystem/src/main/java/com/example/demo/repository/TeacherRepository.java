package com.example.demo.repository;



 import java.util.List;

 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import com.example.demo.model.Teacher;

 
 
 @Repository
 public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

     List<Teacher> findByUsername(String username);

     Teacher findByMob(String mob);

 	Teacher findByEmail(String email);
     
 	
 }