package com.emedicare.service;

import java.util.List;

import com.emedicare.entity.EMedicines;

public interface EmedicineService {

	public List<EMedicines> getEMedicines();
	
	public void saveMedicine(EMedicines medicine);
	
	public void deletebyId(int id);

	public EMedicines getMedicine(int medicineId);


}
