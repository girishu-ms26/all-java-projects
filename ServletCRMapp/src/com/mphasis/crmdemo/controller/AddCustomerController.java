package com.mphasis.crmdemo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.crmdemo.customerdao.CustomerDAO;

/**
 * Servlet implementation class AddCustomerController
 */
@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt((String) request.getParameter("id"));
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		
		CustomerDAO Cadd = new CustomerDAO();
		boolean result = Cadd.addCustomer(id, name, location, email);
		if(result==true) {
			response.sendRedirect("DisplayCustomerController");
		}
		else {
			out.println("Customer ID Already Exists");
		}
	}

}
