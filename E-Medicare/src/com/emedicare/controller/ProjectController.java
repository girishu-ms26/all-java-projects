package com.emedicare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {
	
	@RequestMapping("/Login")
	public String adminLogin() {
		return "login";
	}

}
