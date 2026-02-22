package com.example.demo.dto;

import com.example.demo.model.Student;

public class StudentResponse {

	private Integer roll;
	private String name;
	private String div;
	private String year;
	private String email;
	private Float marks;
	private String mob;

	public StudentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentResponse(Integer roll, String name, String div, String year, String email, Float marks, String role,
			String mob) {
		super();
		this.roll = roll;
		this.name = name;
		this.div = div;
		this.year = year;
		this.email = email;
		this.marks = marks;
		this.mob = mob;
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

	@Override
	public String toString() {
		return "StudentResponse [roll=" + roll + ", name=" + name + ", div=" + div + ", year=" + year + ", email="
				+ email + ", marks=" + marks + ", mob=" + mob + "]";
	}

	public static StudentResponse toDTO(Student s) {

		StudentResponse temp = new StudentResponse();
		temp.setRoll(s.getRoll());
		temp.setName(s.getName());
		temp.setDiv(s.getDiv());
		temp.setYear(s.getYear());
		temp.setEmail(s.getEmail());
		temp.setMarks(s.getMarks());
		temp.setMob(s.getMob());
		return temp;

	}
}