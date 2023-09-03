package com.vaccinemanagement.testdb;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String userName = "scott";
		//String passWord = "tiger";
		String connectionUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		
		//Establish Connection with Database
		
		try {
				PrintWriter out = response.getWriter();
				out.println("Connecting to DataBase with " + connectionUrl );
				Class.forName(jdbcDriver);
				//Connection con = DriverManager.getConnection(connectionUrl,userName,passWord);
				out.println("<br><br> Connection Successful <br><br>");
		}
		catch(Exception E) {
			E.printStackTrace();
		}
	}

}
