package com.example.demo.dto;

import com.example.demo.model.Teacher;

public class TeacherRequest {

	private Integer id;
	private String name;
	private String username;
	private String password;
	private String email;
	private String mob;
	private String role;

	public TeacherRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherRequest(Integer id, String name, String username, String password, String email, String mob,
			String role) {
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
		return "TeacherRequest [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", mob=" + mob + ", role=" + role + "]";
	}

	public static Teacher toEntity(TeacherRequest t) {
		Teacher temp = new Teacher();

		temp.setId(t.getId());
		temp.setName(t.getName());
		temp.setPassword(t.getPassword());
		temp.setEmail(t.getEmail());
		temp.setMob(t.getMob());
		temp.setRole("Teacher");
		temp.setUsername(t.getUsername() + t.getRole());

		return temp;

	}
}