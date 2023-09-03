package com.emedicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emedicare.dao.EmedicineDao;
import com.emedicare.entity.EMedicines;

@Service
public class EmedicineServiceImpl implements EmedicineService {
	
	@Autowired
	private EmedicineDao eMedicineDao;

	@Override
	@Transactional
	public List<EMedicines> getEMedicines() {
		return eMedicineDao.getEMedicines();
	}

	@Override
	@Transactional
	public void deletebyId(int id) {
		eMedicineDao.deletebyId(id);
	}

	@Override
	@Transactional
	public void saveMedicine(EMedicines medicine) {
		eMedicineDao.saveMedicine(medicine);
	}

	@Override
	@Transactional
	public EMedicines getMedicine(int medicineId) {
		return eMedicineDao.getMedicine(medicineId);
	}
	
}