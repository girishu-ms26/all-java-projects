package com.emedicare.dao;

import java.util.List;

import com.emedicare.entity.ECart;

public interface EuserDao {

	public boolean authUser(String username,String password);
	
	public void savetoCart(int medicineId);

	public List<ECart> getCartItems();
	
	public void deleteFromCart(int medicineId);
}
