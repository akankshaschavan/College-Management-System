package com.example.demo.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HoD;

@Repository
public interface HoDRepository extends JpaRepository<HoD, Integer> {

	List<HoD> findByUsername(String username);

	List<HoD> findByDept(String dept);

	List<HoD> findByEmail(String email);

	HoD findByMob(String mob);

	boolean existsByEmail(String email);

	boolean existsByMob(String mob);

}