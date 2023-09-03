package com.mphasis.crud2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.crud2.dao.ordersDAO;

/**
 * Servlet implementation class DeleteOrderController
 */
@WebServlet("/DeleteOrderController")
public class DeleteOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		ordersDAO Odelete = new ordersDAO();
		
		int onum = Integer.parseInt((String) request.getParameter("onum"));
		
		boolean result = Odelete.deleteOrder(onum);
		
		if(result==true) {
			response.sendRedirect("OrderDisplayController");
		}
		else {
			out.println("Fail");
		}
	}

}
