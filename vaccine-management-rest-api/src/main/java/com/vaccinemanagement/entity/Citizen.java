package com.vaccinemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="citizens")
public class Citizen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="refid")
	private long refid;
	
	@Column(name="uid")
	private long uid;
	
	@Column(name="vstatus")
	private int vstatus;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="middle_name")
	private String middle_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phno")
	private long phno;
	
	

	public Citizen() {
		
	}

	public long getRefid() {
		return refid;
	}

	public void setRefid(long refid) {
		this.refid = refid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public int getVstatus() {
		return vstatus;
	}

	public void setVstatus(int vstatus) {
		this.vstatus = vstatus;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "[refid=" + refid + ", uid=" + uid + ", vstatus=" + vstatus + ", first_name=" + first_name
				+ ", middle_name=" + middle_name + ", last_name=" + last_name + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", phno=" + phno + "]";
	}

	
}
