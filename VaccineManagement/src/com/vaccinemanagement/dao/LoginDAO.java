package com.vaccinemanagement.dao;

public interface LoginDAO {
	
	public boolean authAdmin(String userName,String passWord);
	
	public boolean regAdmin(String userName, String passWord);

}
