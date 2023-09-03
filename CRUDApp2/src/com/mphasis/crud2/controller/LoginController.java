package com.mphasis.crud2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.crud2.dao.ordersDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("aname");
		String passWord = request.getParameter("password");
		
		ordersDAO Signin = new ordersDAO();
		
		boolean result = Signin.authenticateUser(userName,passWord);
		if(result==true) {
			response.sendRedirect("OrderDisplayController");
		}
		if(result==false) {
			out.println("Invalid Credentials");
		}
		
	}

}
