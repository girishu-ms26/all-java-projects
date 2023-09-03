package com.spring.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankAppController {
	
	@RequestMapping(value="/Home")
	public ModelAndView homePage() {		
		ModelAndView HomePage = new ModelAndView("Home");		
		return HomePage;		
	}
	
	@RequestMapping(value="/Register",method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView regUser() {
		ModelAndView Reg = new ModelAndView("Register");
		return Reg;
	}
	
	@RequestMapping(value="/Login",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loginPage() {
		ModelAndView login = new ModelAndView("Login");		
		return login;	
	}
	
	@RequestMapping(value="/LoginFail")
	public ModelAndView loginFail() {
		ModelAndView loginFail = new ModelAndView("LoginFail");		
		return loginFail;	
	}
	
	@RequestMapping(value="/Transactions")
	public ModelAndView Transactions() {
		ModelAndView transcations = new ModelAndView("Transactions");
		return transcations;
	}
	
	@RequestMapping(value="/Aboutus")
	public ModelAndView Aboutus() {
		ModelAndView aboutus = new ModelAndView("Aboutus");
		return aboutus;
	}
	
	@RequestMapping(value="/Contact")
	public ModelAndView Contactus() {
		ModelAndView contact = new ModelAndView("Contact");
		return contact;
	}
	@RequestMapping(value="/DeleteAccount")
	public ModelAndView DeleteAcc() {
		ModelAndView delete = new ModelAndView("Delete");
		return delete;
	}
	
	@RequestMapping(value="/UserAuthenticate",method={RequestMethod.POST,RequestMethod.GET})
	public String userAuth(@RequestParam("uname") String uname,@RequestParam("password") String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery("SELECT * FROM Bankusers");			
			while(rs.next()) {
				if(rs.getString(2).equals(uname)) {
					if(rs.getString(3).equals(password)) {
						
						return "redirect:/Transactions";						
					}
				}
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return "redirect:/LoginFail";
	}
	
	@RequestMapping(value="Deposit")
	public ModelAndView Deposit() {
		ModelAndView Dep = new ModelAndView("Deposit");
		return Dep;
	}
	
	@RequestMapping(value="DepositAction",method={RequestMethod.POST,RequestMethod.GET})
	public String DepositAction() {
		return "redirect:/Transactions";
	}
	
	@RequestMapping(value="Withdraw")
	public ModelAndView Withdraw() {
		ModelAndView Wdraw = new ModelAndView("Withdraw");
		return Wdraw;
	}
	
	@RequestMapping(value="WithdrawAction",method={RequestMethod.POST,RequestMethod.GET})
	public String WithdrawAction() {
		return "redirect:/Transactions";
	}
	
	@RequestMapping(value="Transfer")
	public ModelAndView Transfer() {
		ModelAndView transfer = new ModelAndView("Transfer");
		return transfer;
	}
	
	@RequestMapping(value="TransferAction",method={RequestMethod.POST,RequestMethod.GET})
	public String TransferAction() {
		return "redirect:/Transactions";
	}
	
	@RequestMapping(value="ContactAction",method={RequestMethod.POST,RequestMethod.GET})
	public String ContactActions() {
		return "redirect:/Home";
	}
	@RequestMapping(value="DeleteAction",method={RequestMethod.POST,RequestMethod.GET})
	public String DeleteAction() {
		return "redirect:/Home";
	}
}