package com.mphasis.springrestdemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.springrestdemo.entity.Customer;
import com.mphasis.springrestdemo.service.CustomerService;

@RestController
@RequestMapping(value="/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	// Adding the mappings for GET /customers
	@GetMapping(value="/customers")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	@PostMapping(value="/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping(value="/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@GetMapping(value="/customers/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		Customer customer = customerService.getCustomer(id);
		return customer;
	}
	
	@DeleteMapping(value="/customers/{id}")
	public Customer deleteCustomer(@PathVariable("id") int id) {
		Customer customer = customerService.getCustomer(id);
		customerService.deleteCustomer(id);
		return customer;
	}
}
