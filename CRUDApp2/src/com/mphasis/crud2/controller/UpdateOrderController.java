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
 * Servlet implementation class UpdateOrderController
 */
@WebServlet("/UpdateOrderController")
public class UpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int onum = Integer.parseInt((String) request.getParameter("onum")); 
		String odate = request.getParameter("odate");
		double amount = Double.parseDouble((String) request.getParameter("amount"));
		int cnum = Integer.parseInt((String) request.getParameter("cnum"));
		int snum = Integer.parseInt((String) request.getParameter("snum"));
		
		ordersDAO Cupdate = new ordersDAO();
		
		boolean result = Cupdate.updateOrder(onum,odate,amount,cnum,snum);
		
		if(result==true) {
			response.sendRedirect("OrderDisplayController");
		}
		else {
			out.println("Fail");
		}
	}

}
