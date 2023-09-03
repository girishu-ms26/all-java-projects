package com.bankproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankproject.functions.Allbankoperations;

/**
 * Servlet implementation class AccountDetailsServlet
 */
@WebServlet("/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Allbankoperations Details = new Allbankoperations();
		
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("uname");
		int accountNo = Integer.parseInt((String) request.getParameter("accountno"));
		String passWord = request.getParameter("password");
		
		out.println(Details.accountDetails(userName, accountNo, passWord));		
		
		
	}

}
