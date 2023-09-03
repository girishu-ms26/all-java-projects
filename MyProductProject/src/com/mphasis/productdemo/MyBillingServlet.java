package com.mphasis.productdemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyBillingServlet
 */
@WebServlet("/MyBillingServlet")
public class MyBillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String pName = (String) session.getAttribute("Pname");
		double Pqty = Double.parseDouble((String) session.getAttribute("Pqty"));
		double Pprice = Double.parseDouble((String) session.getAttribute("Pprice"));
		
		double billAmount = Pqty * Pprice;
		
		session.setAttribute("BillAmount", billAmount);
		response.sendRedirect("MyDisplayBillServlet");
	}

}
