package com.mphasis.empoperationservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.empmodels.AllEmpOperations;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		String passWord = request.getParameter("password");
		
		AllEmpOperations Login = new AllEmpOperations();
		
		boolean result = Login.authenticateUser(userName,passWord);
		
		if(result) {
			response.sendRedirect("Success.html");
		}
		else {
			response.sendRedirect("Failure.html");
		}
	}
}