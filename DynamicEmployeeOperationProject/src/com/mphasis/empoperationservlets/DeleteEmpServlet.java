package com.mphasis.empoperationservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.empmodels.AllEmpOperations;

/**
 * Servlet implementation class DeleteEmpServlet
 */
@WebServlet("/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Empno = Integer.parseInt((String) request.getParameter("empno"));
		
		AllEmpOperations D1 = new AllEmpOperations();
		boolean result = D1.deleteEmp(Empno);
		if(result==true) {
			response.sendRedirect("SuccessOperation.html");
		}
		else {
			response.sendRedirect("FailureAction.html");
		}
	}

}
