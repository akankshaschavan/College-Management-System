package com.example.demo.dto;

import com.example.demo.model.Teacher;

public class TeacherResponse {

	private Integer id;
	private String name;
	private String email;
	private String mob;

	public TeacherResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherResponse(Integer id, String name, String email, String mob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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

	@Override
	public String toString() {
		return "TeacherResponse [id=" + id + ", name=" + name + ", email=" + email + ", mob=" + mob + "]";
	}

	public static TeacherResponse toDTO(Teacher t) {
		TeacherResponse temp = new TeacherResponse();

		temp.setId(t.getId());
		temp.setName(t.getName());
		temp.setEmail(t.getEmail());
		temp.setMob(t.getMob());
		return temp;

	}

}