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

import com.example.demo.dto.HoDRequest;
import com.example.demo.dto.HoDResponse;
import com.example.demo.model.HoD;
import com.example.demo.service.HoDService;



@RestController
@RequestMapping("/hod")
public class HoDController {

	@Autowired
	private HoDService hodservice;

	@PostMapping("add")
	public void add(@RequestBody HoDRequest hodrequest, Integer id) {
		hodservice.add(hodrequest);
	}

	
	@DeleteMapping("delete/{id}")
	public HoDResponse delete(@PathVariable Integer id) {
		return hodservice.delete(id);
	}

	

	@GetMapping("display")
	public List<HoDResponse> display() {
		return hodservice.display();
	}

	
	@GetMapping("search/{id}")
	public ResponseEntity<?> search(@PathVariable Integer id) {
		HoD temp = hodservice.search(id);
		if (temp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.ok(temp);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id,@RequestBody HoDRequest request){
		hodservice.update(request, id);
		return ResponseEntity.ok("Updated Sucessfully");
		
}
	
	
	@PostMapping("add-all")
	public void addAll(@RequestBody List<HoDRequest> list) {
		hodservice.addAll(list);
	}
	
	
}