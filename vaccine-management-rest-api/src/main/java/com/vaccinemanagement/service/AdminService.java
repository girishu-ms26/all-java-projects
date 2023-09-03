package com.vaccinemanagement.service;

import java.util.List;

import com.vaccinemanagement.entity.Adminsapi;

public interface AdminService {

	public List<Adminsapi> getAdmins();
	
	public boolean login(String username,String password);
}
