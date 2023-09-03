package com.bankproject.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankproject.functions.Allbankoperations;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Allbankoperations Delete = new Allbankoperations();
		
		String userName = request.getParameter("uname");
		int accountNo = Integer.parseInt((String) request.getParameter("accountno"));
		String passWord = request.getParameter("password");
		
		if(Delete.deleteAccount(userName, accountNo, passWord)==true) {
			response.sendRedirect("welcome.html");
		}
		else {
			response.sendRedirect("FailureAction.html");
		}
	}
}