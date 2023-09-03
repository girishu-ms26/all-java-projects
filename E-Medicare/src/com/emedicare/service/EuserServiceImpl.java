package com.emedicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emedicare.dao.EuserDao;
import com.emedicare.entity.ECart;

@Service
public class EuserServiceImpl implements EuserService {

	@Autowired
	private EuserDao euserDao;
	
	@Override	
	public boolean authUser(String userName, String passWord) {
		return euserDao.authUser(userName, passWord);
	}

	@Override
	@Transactional
	public void savetoCart(int medicineId) {
		euserDao.savetoCart(medicineId);
	}

	@Override
	@Transactional
	public List<ECart> getCartItems() {
		return euserDao.getCartItems();
	}

	@Override
	@Transactional
	public void deleteFromCart(int medicineId) {
		euserDao.deleteFromCart(medicineId);
	}
	
	

}
