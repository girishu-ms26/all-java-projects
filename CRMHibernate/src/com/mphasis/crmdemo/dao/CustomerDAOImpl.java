package com.mphasis.crmdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.crmdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// We will inject the SessionFactory using Spring Framework Autowire mechanism
	// We are outsourcing the process of object creation to Spring Framework
	// This is a Core Spring Principle --- Inversion of Control
	// And that object is injected here ---- Dependency Injection
	// Because we are dependent on SessionFactory to read the Database Connection Info
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override	
	public List<Customer> getCustomers() {
		// Getting the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();		
		// Create the Query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);		
		// Get the Result by executing the query 
		List<Customer> customers = theQuery.getResultList();		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// Getting the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		// We are using a combinational method 
		// which is the combination of save and update
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// Getting the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		// Retrieving the Customer object from Database using Primary Key
		Customer theCustomer = currentSession.get(Customer.class, theId);		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		currentSession.delete(theCustomer);
	}

}
