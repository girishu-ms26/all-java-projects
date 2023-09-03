package com.bankproject.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankproject.functions.Allbankoperations;

/**
 * Servlet implementation class RegisterServler
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int accountNumber = Integer.parseInt((String) request.getParameter("accountno"));
		String userName = request.getParameter("uname");
		String passWord = request.getParameter("password");		
		
		Allbankoperations Register = new Allbankoperations();		
		
		boolean result = Register.registerBankuser(accountNumber, userName, passWord);
		
		if(result==true) {
			response.sendRedirect("welcome.html");
		}
		if(result==false) {
			response.sendRedirect("FailureAction.html");
		}
	}

}
