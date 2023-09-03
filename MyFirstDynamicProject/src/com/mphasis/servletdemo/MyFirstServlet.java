package com.mphasis.servletdemo;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyFirstServlet() {
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Getting the Writer to Response Object
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
		
	}

}
