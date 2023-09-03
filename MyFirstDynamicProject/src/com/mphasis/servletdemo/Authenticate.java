package com.mphasis.servletdemo;

import java.sql.*;

public class Authenticate {

	public boolean authenticateUser(String userName,String passWord) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st1.executeQuery("SELECT * FROM Users");			
			while(rs.next()) {
				if(rs.getString(1).equals(userName)) {
					if(rs.getString(2).equals(passWord)) {
						return true;
					}
				}
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return false;
	}
}