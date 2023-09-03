package com.mphasis.crud2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.crud2.dao.ordersDAO;
import com.mphasis.crud2.entity.Order;

/**
 * Servlet implementation class OrderDisplayController
 */
@WebServlet("/OrderDisplayController")
public class OrderDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Order> Orders = new ArrayList<Order>();
		
		ordersDAO O = new ordersDAO();
		
		Orders = O.getOrders();
		request.setAttribute("Odata", Orders);
		
		RequestDispatcher rd = request.getRequestDispatcher("Orders-List.jsp");
		rd.forward(request, response);
	}

}
