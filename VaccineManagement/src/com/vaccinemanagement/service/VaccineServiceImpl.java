package com.vaccinemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaccinemanagement.dao.LoginDAOImpl;
import com.vaccinemanagement.dao.VaccineDAO;
import com.vaccinemanagement.entity.Citizen;
import com.vaccinemanagement.entity.Contact;

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

	@Override
	@Transactional
	public boolean authAdmin(String userName, String passWord) {
		LoginDAOImpl login = new LoginDAOImpl();
		return login.authAdmin(userName, passWord);
	}
	
	@Override
	@Transactional
	public boolean regAdmin(String userName, String passWord) {
		LoginDAOImpl login = new LoginDAOImpl();
		return login.regAdmin(userName, passWord);
	}

	@Override
	@Transactional
	public void Contact(Contact theContact) {
		vaccineDAO.Contact(theContact);
	}

	@Override
	@Transactional
	public List<Citizen> searchCitizen(String Fname) {
		return vaccineDAO.searchCitizen(Fname);
	}
}
