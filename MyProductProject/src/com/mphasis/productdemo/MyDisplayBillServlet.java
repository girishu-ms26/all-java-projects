package com.mphasis.productdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyDisplayBillServlet
 */
@WebServlet("/MyDisplayBillServlet")
public class MyDisplayBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		
		double BillAmount = (double) session.getAttribute("BillAmount");
		
		String Productname = (String) session.getAttribute("Pname");		
		
		pw.println("The Product Name is "+Productname);
		
		pw.println("The Bill Amount is "+BillAmount);
		
		pw.println("The billing	is successful....Good BYE");
	}

}
