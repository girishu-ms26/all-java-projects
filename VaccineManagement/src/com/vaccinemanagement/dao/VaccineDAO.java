package com.vaccinemanagement.dao;

import java.util.List;

import com.vaccinemanagement.entity.Citizen;
import com.vaccinemanagement.entity.Contact;

public interface VaccineDAO {
	
	public List<Citizen> getCitizens();
	
	public void saveCitizen(Citizen theCitizen);
	
	public Citizen getCitizen(long refId);
	
	public void deleteCitizen(long refId);
	
	public void Contact(Contact theContact);
	
	public List<Citizen> searchCitizen(String Fname);
	
}