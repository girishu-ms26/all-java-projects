package com.bankproject.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankproject.functions.Allbankoperations;

/**
 * Servlet implementation class ContactusServlet
 */
@WebServlet("/ContactusServlet")
public class ContactusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactusServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		long phNo = Long.parseLong((String)request.getParameter("phno"));
		String eMail = request.getParameter("email");
		String uProblem = request.getParameter("problem");
		
		Allbankoperations contactus = new Allbankoperations();
		
		boolean result = contactus.contactUs(userName, phNo, eMail, uProblem);
		if(result) {
			response.sendRedirect("welcome.html");
		}
		else {
			response.sendRedirect("FailureAction.html");
		}
	}

}
