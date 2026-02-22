package com.example.demo.dto;

import com.example.demo.model.HoD;

public class HoDRequest {

	private Integer id;
	private String name;
	private Integer exp;
	private String username;
	private String email;
	private String dept;
	private String password;
	private String mob;
	private String role;

	public HoDRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoDRequest(Integer id, String name, Integer exp, String username, String email, String dept, String password,
			String role, String mob) {
		super();
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.username = username;
		this.email = email;
		this.dept = dept;
		this.password = password;
		this.role = role;
		this.mob = mob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	@Override
	public String toString() {
		return "HoDRequest [id=" + id + ", name=" + name + ", exp=" + exp + ", username=" + username + ", email="
				+ email + ", dept=" + dept + ", password=" + password + ", role=" + role + ", mob=" + mob + "]";
	}

	public static HoD toEntity(HoDRequest h) {

		HoD temp = new HoD();
		temp.setId(h.getId());
		temp.setName(h.getName());
		temp.setExp(h.getExp());
		temp.setEmail(h.getEmail());
		temp.setDept(h.getDept());
		temp.setPassword(h.getPassword());
		temp.setMob(h.getMob());
		temp.setRole("HoD");
		temp.setUsername(h.getUsername() + h.getRole());
		return temp;

	}
}