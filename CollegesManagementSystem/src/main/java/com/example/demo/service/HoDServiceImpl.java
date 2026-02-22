package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.HoDRequest;
import com.example.demo.dto.HoDResponse;
import com.example.demo.exception.InvalidDepartment;
import com.example.demo.exception.InvalidEmail;
import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.model.HoD;
import com.example.demo.repository.HoDRepository;

@Service
public class HoDServiceImpl implements HoDService {

    @Autowired
    private HoDRepository hodrepository;

    @Override
    public void add(HoDRequest hodRequest) {
        List<HoD> list = hodrepository.findAll();

        String mob = hodRequest.getMob();
        if (mob != null) {
            mob = mob.trim();
        }

        if (mob.length() == 10) {
            if (mob.charAt(0) >= '0' && mob.charAt(0) <= '5') {
                throw new InvalidMobileNumber("Invalid Mobile Number");
            }
        }

        for (int i = 0; i < mob.length(); i++) {
            if (!Character.isDigit(mob.charAt(i)))
                throw new InvalidMobileNumber("Invalid Mobile Number");
        }

        HoD existing = hodrepository.findByMob(mob);
        if (existing != null) {
            throw new InvalidMobileNumber("Mobile Already Exist");
        }

        Integer id = hodRequest.getId();
        if (id == null || id <= 0) {
            throw new InvalidId("ID Must Be Positive");
        }

        for (HoD h : list) {
            if (h.getId().equals(id)) {
                throw new InvalidId("Id Already Exists");
            }
        }

        String email = hodRequest.getEmail();
        if (email == null) {
            throw new InvalidEmail("Invalid Email");
        }

        if (!hodrepository.findByEmail(email).isEmpty()) {
            throw new InvalidEmail("Email Already Exists");
        }

        List<String> validDepartment = List.of("BCS", "BCA", "IT", "CS", "ENTC");
        if (!validDepartment.contains(hodRequest.getDept().toUpperCase())) {
            throw new InvalidDepartment("Invalid Department");
        }

        HoD hodEntity = HoDRequest.toEntity(hodRequest);
        hodrepository.save(hodEntity);
    }

    
    
    @Override
    public List<HoDResponse> display() {
        List<HoD> hodList = hodrepository.findAll();
        List<HoDResponse> responseList = new ArrayList<>();
        for (HoD hod : hodList) {
            responseList.add(HoDResponse.toDTO(hod));
        }
        return responseList;
    }

    
    
    @Override
    public HoDResponse delete(Integer id) {
        HoD hod = hodrepository.findById(id).orElse(null);
        if (hod != null) {
            hodrepository.delete(hod);
            return HoDResponse.toDTO(hod);
        }
        return null;
    }

    
    
    @Override
    public HoDResponse update(HoDRequest request, Integer id) {
        HoD hod = hodrepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id Is Invalid"));

        hod.setName(request.getName());
        hod.setDept(request.getDept());
        hod.setEmail(request.getEmail());
        hod.setExp(request.getExp());
        hod.setMob(request.getMob());

        HoD updated = hodrepository.save(hod);
        return HoDResponse.toDTO(updated);
    }

    
    
    @Override
    public List<HoD> findByEmail(String email) {
        return hodrepository.findByEmail(email);
    }

    
    
    @Override
    public boolean existsByMob(String mob) {
        return hodrepository.existsByMob(mob);
    }
    
    

    @Override
    public HoD findByMob(String mob) {
        return hodrepository.findByMob(mob);
    }

    
    @Override
    public HoD search(Integer id) {
        return hodrepository.findById(id).orElse(null);
    }

    
    @Override
    public void addAll(List<HoDRequest> list) {
        List<HoD> hods = list.stream().map(HoDRequest::toEntity).toList();
        hodrepository.saveAll(hods);
    }
    
    
}