package com.bankproject.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankproject.functions.Allbankoperations;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Allbankoperations Withdraw = new Allbankoperations();
		
		String userName = request.getParameter("uname");
		int accountNo = Integer.parseInt((String) request.getParameter("accountno"));
		double amount = Double.parseDouble((String) request.getParameter("amount"));
		
		boolean result = Withdraw.withdrawAmount(userName, accountNo, amount);
		if(result==true) {
			response.sendRedirect("Bank_Transaction.html");
		}
		if(result==false) {
			response.sendRedirect("FailureAction.html");
		}
	}
}