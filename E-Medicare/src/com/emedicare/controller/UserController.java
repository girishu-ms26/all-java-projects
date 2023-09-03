package com.emedicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emedicare.entity.ECart;
import com.emedicare.service.EuserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private EuserService euserService;
	
	@GetMapping("/cartItems")
	public String medicinelist(Model theModel) {
		List<ECart> CartItems = euserService.getCartItems();
		theModel.addAttribute("CartItems", CartItems);
		return "cart";
	}
	
	@PostMapping("/Ulogin")
	public String authUser(@RequestParam("uname")String userName,@RequestParam("password") String passWord) {
		boolean result = euserService.authUser(userName, passWord);
		if(result==true) {
			return "redirect:/medicines/medicineforUser";
		}
		else {
			return "invalidCredentials";
		}
	}
	
	@GetMapping("/addtoCart")
	public String buyMed(@RequestParam("medicineid") int medicineid) {
		euserService.savetoCart(medicineid);
		return "redirect:/medicines/medicineforUser";
	}
	
	@GetMapping("/deleteFromCart")
	public String delete(@RequestParam("medicineid") int id) {
		euserService.deleteFromCart(id);
		return "redirect:/user/cartItems";
	}
}
