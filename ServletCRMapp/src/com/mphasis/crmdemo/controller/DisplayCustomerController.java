package com.mphasis.crmdemo.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.crmdemo.customerdao.CustomerDAO;
import com.mphasis.crmdemo.entity.Customer;

/**
 * Servlet implementation class DisplayCustomerController
 */
@WebServlet("/DisplayCustomerController")
public class DisplayCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Customer> Customers = new ArrayList<Customer>();
		
		CustomerDAO cust = new CustomerDAO();
		
		Customers = cust.getCustomer();
		request.setAttribute("custdata", Customers);
		
		RequestDispatcher rd = request.getRequestDispatcher("list-customer.jsp");
		rd.forward(request, response);
	}

}
