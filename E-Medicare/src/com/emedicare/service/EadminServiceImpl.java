package com.emedicare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emedicare.dao.EadminDao;

@Service
public class EadminServiceImpl implements EadminService {

	@Autowired
	private EadminDao eAdminDao;

	@Override
	@Transactional
	public boolean authAdmin(String admin, String password) {
		return eAdminDao.authAdmin(admin, password);
	}
	
	
}
