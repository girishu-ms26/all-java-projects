package com.vaccinemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaccinemanagement.entity.Citizen;
import com.vaccinemanagement.entity.Contact;
import com.vaccinemanagement.service.VaccineService;

@Controller
@RequestMapping("/citizen")
public class VaccinemanagementController {
	
	@Autowired
	private VaccineService vaccineService;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/list")
	public String listCitizens(Model theModel) {
		List<Citizen> theCitizens = vaccineService.getCitizens();
		theModel.addAttribute("citizens", theCitizens);
		return "list-citizens";
	}
	
	@GetMapping("/searchCitizen")
	public String searchCitizen(@RequestParam("Fname") String Fname,Model theModel) {
		List<Citizen> theCitizens = vaccineService.searchCitizen(Fname);
		theModel.addAttribute("citizens", theCitizens);
		return "list-citizens";
	}
	
	@GetMapping("/addCitizen")
	public String addCitizen(Model theModel) {
		Citizen theCitizen = new Citizen();
		theModel.addAttribute("citizen",theCitizen);
		return "citizen-form";
	}
	
	@PostMapping("/saveCitizen")
	public String saveCitizen(@ModelAttribute("citizen") Citizen theCitizen) {
		vaccineService.saveCitizen(theCitizen);
		return "redirect:/citizen/list";
	}
	
	@GetMapping("/updateCitizen")
	public String updateCitizen(@RequestParam("citizenRefId") long refId, Model theModel) {
		Citizen theCitizen = vaccineService.getCitizen(refId);
		theModel.addAttribute("citizen",theCitizen);
		return "citizen-form";
	}
	
	@GetMapping("/deleteCitizen")
	public String deleteCitizen(@RequestParam("citizenRefId") long refId) {
		vaccineService.deleteCitizen(refId);
		return "redirect:/citizen/list";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@PostMapping("/thankyouforContacting")
	public String thankyouforContacting(@ModelAttribute("contact") Contact theContact) {
		vaccineService.Contact(theContact);
		return "redirect:/";
	}
	
	@GetMapping("/services")
	public String services() {
		return "services";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@ExceptionHandler(Exception.class)
	public String Exception(Exception E) {
		return "InvalidEntry";
	}
}