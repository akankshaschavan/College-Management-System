package com.example.demo.dto;

import com.example.demo.model.Student;

public class StudentRequest {

	private Integer roll;
	private String name;
	private String div;
	private String year;
	private String username;
	private String password;
	private String email;
	private Float marks;
	private String mob;
	private String role;
	

	public StudentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentRequest(Integer roll, String name, String div, String year, String username, String password,
			String email, Float marks, String mob, String role) {
		super();
		this.roll = roll;
		this.name = name;
		this.div = div;
		this.year = year;
		this.username = username;
		this.password = password;
		this.email = email;
		this.marks = marks;
		this.mob = mob;
		this.role = role;
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getMarks() {
		return marks;
	}

	public void setMarks(Float marks) {
		this.marks = marks;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "StudentRequest [roll=" + roll + ", name=" + name + ", div=" + div + ", year=" + year + ", username="
				+ username + ", password=" + password + ", email=" + email + ", marks=" + marks + ", mob=" + mob
				+ ", role=" + role + "]";
	}

	public static Student toEntity(StudentRequest e) {
		Student temp = new Student();
		temp.setRoll(e.getRoll());
		temp.setName(e.getName());
		temp.setDiv(e.getDiv());
		temp.setYear(e.getYear());
		temp.setPassword(e.getPassword());
		temp.setEmail(e.getEmail());
		temp.setMarks(e.getMarks());
		temp.setMob(e.getMob());
		temp.setRole("Student");
		temp.setUsername(e.getUsername() + e.getRole());
		return temp;

	}
}