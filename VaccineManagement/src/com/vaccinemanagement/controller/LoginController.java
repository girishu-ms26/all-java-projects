package com.vaccinemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vaccinemanagement.service.VaccineService;


@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@Autowired
	private VaccineService vaccineService;
	
	@GetMapping("/login")
	public String loginPage(Model theModel) {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage(Model theModel) {
		return "register";
	}
	
	@PostMapping("/registering")
	public String registering(@RequestParam("username")String userName,@RequestParam("password") String passWord) {
		boolean result = vaccineService.regAdmin(userName, passWord);
		if(result == true) {
			return "redirect:/admin/login";
		}
		else {
			return "loginFail";
		}
	}
	@PostMapping("/authenticating")
	public String authAdmin(@RequestParam("username")String userName,@RequestParam("password") String passWord) {
		boolean result = vaccineService.authAdmin(userName, passWord);
		if(result == true) {
			return "redirect:/citizen/list";
		}
		else {
			return "loginFail";
		}
	}
}