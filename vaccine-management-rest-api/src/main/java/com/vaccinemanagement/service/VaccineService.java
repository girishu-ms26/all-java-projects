package com.vaccinemanagement.service;

import java.util.List;

import com.vaccinemanagement.entity.Citizen;

public interface VaccineService {

	public List<Citizen> getCitizens();
	
	public void saveCitizen(Citizen theCitizen);
	
	public Citizen getCitizen(long refId);
	
	public void deleteCitizen(long refId);
	
	
	
}