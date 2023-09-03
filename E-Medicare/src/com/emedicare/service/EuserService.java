package com.emedicare.service;

import java.util.List;

import com.emedicare.entity.ECart;

public interface EuserService {

	public boolean authUser(String userName, String passWord);
	
	public void savetoCart(int medicineId);
	
	public List<ECart> getCartItems();
	
	public void deleteFromCart(int medicineId);

}
