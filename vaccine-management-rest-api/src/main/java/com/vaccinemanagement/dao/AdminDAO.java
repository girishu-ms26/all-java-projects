package com.vaccinemanagement.dao;

import java.util.List;

import com.vaccinemanagement.entity.Adminsapi;

public interface AdminDAO {
	
	public boolean register(String username,String password);
	public boolean login (String username,String password);
	public List<Adminsapi> getAdmins();

}
