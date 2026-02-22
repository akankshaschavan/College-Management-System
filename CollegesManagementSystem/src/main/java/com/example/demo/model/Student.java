package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Student {

	@Id
	private Integer roll;

	private String name;

	@Column(name = "division")
	private String div;

	@Column(name = "academic_year")
	private String year;

	private String username;
	private String password;
	private String email;
	private Float marks;
	private String role;
	private String mob;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer roll, String name, String div, String year, String username, String password, String email,
			Float marks, String role, String mob) {
		super();
		this.roll = roll;
		this.name = name;
		this.div = div;
		this.year = year;
		this.username = username;
		this.password = password;
		this.email = email;
		this.marks = marks;
		this.role = role;
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
		return "Student [roll=" + roll + ", name=" + name + ", div=" + div + ", year=" + year + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", marks=" + marks + ", role=" + role + ", mob=" + mob
				+ "]";
	}

}