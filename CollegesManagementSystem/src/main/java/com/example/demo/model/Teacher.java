package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teacher {

	@Id
	private Integer id;
	private String name;
	private String username;
	private String password;
	private String email;
	private String mob;
	private String role;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(Integer id, String name, String username, String password, String email, String mob, String role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mob = mob;
		this.role = role;
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
		return "Teacher [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", email="
				+ email + ", mob=" + mob + ", role=" + role + "]";
	}
	
	
}