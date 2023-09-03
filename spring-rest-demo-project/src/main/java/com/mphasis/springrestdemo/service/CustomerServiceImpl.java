package com.mphasis.springrestdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.springrestdemo.dao.CustomerDAO;
import com.mphasis.springrestdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Need to inject CustomerDAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {		
		// We are delegating the call to DAO method through Service Layer
		return customerDAO.getCustomers() ;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {		
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {		
		 customerDAO.deleteCustomer(theId);		
	}
}
