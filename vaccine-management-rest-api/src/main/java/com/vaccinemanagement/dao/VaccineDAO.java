package com.vaccinemanagement.dao;

import java.util.List;

import com.vaccinemanagement.entity.Citizen;

public interface VaccineDAO {
	
	public List<Citizen> getCitizens();
	
	public void saveCitizen(Citizen theCitizen);
	
	public Citizen getCitizen(long refId);
	
	public void deleteCitizen(long refId);
	
}