package com.emedicare.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class EadminDaoImpl implements EadminDao {

	@Override
	public boolean authAdmin(String admin, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","scott","tiger");
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery("SELECT * FROM EAdmins");			
			while(rs.next()) {
				if(rs.getString(2).equals(admin)) {
					if(rs.getString(3).equals(password)) {
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
