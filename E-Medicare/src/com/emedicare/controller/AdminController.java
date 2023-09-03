package com.emedicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emedicare.service.EadminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private EadminService eadminService;
	
	@PostMapping("/Alogin")
	public String authAdmin(@RequestParam("admin")String userName,@RequestParam("password") String passWord) {
		boolean result = eadminService.authAdmin(userName, passWord);
		if(result==true) {
			return "redirect:/medicines/medicinelist";
		}
		else {
			return "invalidCredentials";
		}
	}
}
