package com.vaccinemanagement.restcontroller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccinemanagement.entity.Adminsapi;
import com.vaccinemanagement.service.AdminService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api/v1",produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminLoginController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping(value="/admins")
	public List<Adminsapi> getAdmins(){
		return adminService.getAdmins();
	}
	
	@PostMapping(value="/admins")
	public Map<String, Boolean> login(@RequestBody Adminsapi theAdmin) {
		String username=theAdmin.getUsername();
		String password=theAdmin.getPassword();
		boolean status = adminService.login(username, password);
		if(status==true) {
			return Collections.singletonMap("status", true);
		}
		else {
			return Collections.singletonMap("status", false);
		}
		//return adminService.login(username, password);
	}

}
