package com.example.demo.dto;




import com.example.demo.model.HoD;

public class HoDResponse {

	private Integer id;
	private String name;
	private Integer exp;
	private String email;
	private String dept;
	private String mob;

	public HoDResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoDResponse(Integer id, String name, Integer exp, String email, String dept, String mob) {
		super();
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.email = email;
		this.dept = dept;
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

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	@Override
	public String toString() {
		return "HoDResponse [id=" + id + ", name=" + name + ", exp=" + exp + ", email=" + email + ", dept=" + dept
				+ ", mob=" + mob + "]";
	}
	
//	public static HoD toEntity(HoDRequest h) {

	public static HoDResponse toDTO(HoD h) {
		HoDResponse temp = new HoDResponse();

		temp.setId(h.getId());
		temp.setName(h.getName());
		temp.setExp(h.getExp());
		temp.setEmail(h.getEmail());
		temp.setDept(h.getDept());
		temp.setMob(h.getMob());
		return temp;

	}
}