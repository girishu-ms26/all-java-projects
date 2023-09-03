package com.mphasis.productdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyProductReadServlet
 */
@WebServlet("/MyProductReadServlet")
public class MyProductReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyProductReadServlet() {
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String ProductName = request.getParameter("pname");
		String Quantity = request.getParameter("pqty");
		String Price = request.getParameter("pprice");
		
		//Creating Session Object and setting the attributes and their values
		//Using setAttribute("Name of session attribute",value to be set) method of httpSession class
		HttpSession session = request.getSession();
		session.setAttribute("Pname",ProductName);
		session.setAttribute("Pqty",Quantity);
		session.setAttribute("Pprice",Price);
		
		// Sending a floating object to MyBillingServlet
		response.sendRedirect("MyBillingServlet");
	}

}
