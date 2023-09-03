package com.emedicare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Eadmins")
public class EAdmins {

	@Id
	@GeneratedValue()
	@Column(name="adminid")
	private int adminid;
	
	@Column(name="admin")
	private String admin;
	
	@Column(name="password")
	private String password;
	
	

	public EAdmins() {
		super();
	}

	public EAdmins(int adminid, String admin, String password) {
		super();
		this.adminid = adminid;
		this.admin = admin;
		this.password = password;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}