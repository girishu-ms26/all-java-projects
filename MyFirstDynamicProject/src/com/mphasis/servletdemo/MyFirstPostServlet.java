package com.mphasis.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstPostServlet
 */
@WebServlet("/MyFirstPostServlet")
public class MyFirstPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("uname");
		String passWord = request.getParameter("password");
		
		//System.out.println("Hi....");
		//System.out.println("My First Servlet Code");
		out.println("<HTML><BODY>");
		
		out.println("<H2>Hi....</H2>");
		
		out.println("<H3>My First Servlet Code</H3>");
		
		out.println("Welcome... "+userName);
		
		out.println("You are Identified by .... "+passWord);
		
		out.println("</BODY></HTML>");
		
		Authenticate A1 = new Authenticate();
		
		boolean result = A1.authenticateUser(userName,passWord);
		
		if(result) {
			response.sendRedirect("Success.html");
		}
		else {
			response.sendRedirect("Failure.html");
		}
		
	}
}