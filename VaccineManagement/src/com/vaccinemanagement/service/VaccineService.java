package com.vaccinemanagement.service;

import java.util.List;

import com.vaccinemanagement.entity.Citizen;
import com.vaccinemanagement.entity.Contact;

public interface VaccineService {

	public List<Citizen> getCitizens();
	
	public void saveCitizen(Citizen theCitizen);
	
	public Citizen getCitizen(long refId);
	
	public void deleteCitizen(long refId);
	
	public boolean authAdmin(String userName,String passWord);
	
	public void Contact(Contact theContact);
	
	public boolean regAdmin(String userName, String passWord);
	
	public List<Citizen> searchCitizen(String Fname);
	
}