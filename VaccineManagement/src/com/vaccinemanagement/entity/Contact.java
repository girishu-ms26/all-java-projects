package com.vaccinemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ContactUs")
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="refid")
	private long refid;

	@Column(name="Name")
	private String Name;
	
	@Column(name="phno")
	private String phno;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Problem")
	private String Problem;

	public long getRefid() {
		return refid;
	}

	public void setRefid(long refid) {
		this.refid = refid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getProblem() {
		return Problem;
	}

	public void setProblem(String problem) {
		Problem = problem;
	}

	
}
