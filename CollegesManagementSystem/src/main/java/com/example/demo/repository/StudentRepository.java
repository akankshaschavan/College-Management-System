package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByRoll(Integer roll);

	List<Student> findByUsername(String username);

	List<Student> findByDiv(String div);

	List<Student> findByYear(String year);

	Student findByMob(String mob);

	Student findByEmail(String email);

	boolean existsByMob(String mob);
}