package com.mphasis.empoperationservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayallEmpServlet
 */
@WebServlet("/DisplayallEmpServlet")
public class DisplayallEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
			try {			
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				Statement st1 = con.createStatement();	
				ResultSet rs = st1.executeQuery("SELECT * FROM emp");
				
				while(rs.next()) {
					
					out.println(""+ rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getDate(5)+"  "+rs.getDouble(6)+"  "+rs.getDouble(7)+"  "+rs.getInt(8)+"");
					
				}
			}
			catch(Exception E) {
				E.printStackTrace();
			}
	}
}
