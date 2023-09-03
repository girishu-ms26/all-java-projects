package com.vaccinemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaccinemanagement.dao.VaccineDAO;
import com.vaccinemanagement.entity.Citizen;

@Service
public class VaccineServiceImpl implements VaccineService {
	
	@Autowired
	private VaccineDAO vaccineDAO;

	@Override
	@Transactional
	public List<Citizen> getCitizens() {
		return vaccineDAO.getCitizens();
	}

	@Override
	@Transactional
	public void saveCitizen(Citizen theCitizen) {		
		vaccineDAO.saveCitizen(theCitizen);
	}

	@Override
	@Transactional
	public Citizen getCitizen(long refId) {
		return vaccineDAO.getCitizen(refId);
	}

	@Override
	@Transactional
	public void deleteCitizen(long refId) {
		vaccineDAO.deleteCitizen(refId);
	}
	
	
}
