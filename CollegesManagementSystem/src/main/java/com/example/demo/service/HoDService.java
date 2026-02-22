package com.example.demo.service;



import java.util.List;

import com.example.demo.dto.HoDRequest;
import com.example.demo.dto.HoDResponse;
import com.example.demo.model.HoD;


public interface HoDService {

	void add(HoDRequest hodreRequest);

	List<HoDResponse> display();

	HoDResponse delete(Integer id);

	HoDResponse update(HoDRequest hod, Integer id);

	List<HoD> findByEmail(String email);

	boolean existsByMob(String mob);

	HoD findByMob(String mob);

	HoD search(Integer id);

	void addAll(List<HoDRequest> list);

}