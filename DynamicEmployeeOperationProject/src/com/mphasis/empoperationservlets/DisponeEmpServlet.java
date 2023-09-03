package com.mphasis.empoperationservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.empmodels.AllEmpOperations;

/**
 * Servlet implementation class DisponeEmp
 */
@WebServlet("/DisponeEmpServlet")
public class DisponeEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		AllEmpOperations D1 = new AllEmpOperations();
		int Empno =  Integer.parseInt((String) request.getParameter("empno"));
		out.println();
		out.println(D1.dispEmp(Empno));
		
		
	}

}
