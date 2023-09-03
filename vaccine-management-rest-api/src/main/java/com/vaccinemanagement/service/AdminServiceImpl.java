package com.vaccinemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaccinemanagement.dao.AdminDAO;
import com.vaccinemanagement.entity.Adminsapi;

@Service
public class AdminServiceImpl implements AdminService	 {
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional	
	public boolean login(String username, String password) {
		return adminDAO.login(username, password);
	}

	@Override
	@Transactional
	public List<Adminsapi> getAdmins() {
		return adminDAO.getAdmins();
	}

}
