package com.vaccinemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean authAdmin(String userName, String passWord) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","scott","tiger");
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery("SELECT * FROM Admins");			
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

	@Override
	public boolean regAdmin(String userName, String passWord) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","scott","tiger");			
			PreparedStatement RegAdmin = con.prepareStatement("INSERT INTO `Admins` VALUES (?,?)");
			RegAdmin.setString(1,userName);
			RegAdmin.setString(2,passWord);		
			int i = RegAdmin.executeUpdate();
			if(i==1) {
				return true;
			}
			if(i!=1) {
				return false;
			}		
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return false;
	}
	
	
}