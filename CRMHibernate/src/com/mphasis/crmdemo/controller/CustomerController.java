package com.mphasis.crmdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mphasis.crmdemo.entity.Customer;
import com.mphasis.crmdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// Injecting the CustomerService here
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		// ModelAndView model = new ModelAndView("list-customers");		
		// Get customers from DAO Method
		List<Customer> theCustomers = customerService.getCustomers();		
		// Adding them on to Model Object		
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}	
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel){
		// Creating the Model Attribute and binding the Form Data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){		
		customerService.saveCustomer(theCustomer);		
		return "redirect:/customer/list";		
	}	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){		
		// Getting the customer from database based on this theId
		Customer theCustomer = customerService.getCustomer(theId);		
		// Setting this Customer as a Model Attribute		
		theModel.addAttribute("customer", theCustomer);
		
		// Sending this to form so that the form will be pre-populated
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId){
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}