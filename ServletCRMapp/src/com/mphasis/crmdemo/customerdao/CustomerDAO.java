package com.mphasis.crmdemo.customerdao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.crmdemo.entity.Customer;

public class CustomerDAO {

	String ConnectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
	String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	String userName = "scott";
	String passWord = "tiger";
	
	
	public List<Customer> getCustomer(){		
		List<Customer> Customers = new ArrayList<Customer>();		
		
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(ConnectionURL,userName,passWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM  CustomersJSP");
			while(rs.next()) {
				Customer C = new Customer();
				C.setId(rs.getInt(1));
				C.setName(rs.getString(2));
				C.setLocation(rs.getString(3));
				C.seteMail(rs.getString(4));
				Customers.add(C);
			}
			con.close();
			
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return Customers;
	}
	
	public boolean updateCustomer(int id,String name,String location,String email) {
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(ConnectionURL,userName,passWord);
			PreparedStatement Cupdate = con.prepareStatement("UPDATE CustomersJSP SET Name = ?,Location = ?,Email = ? WHERE ID = ?");
			Cupdate.setString(1,name);;
			Cupdate.setString(2,location);
			Cupdate.setString(3,email);
			Cupdate.setInt(4,id);
			int i = Cupdate.executeUpdate();
			if(i==1) {
				return true;
			}
		}
		catch(Exception E) {
			E.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteCustomer(int id,String name,String location,String email) {
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(ConnectionURL,userName,passWord);
			PreparedStatement Cdelete = con.prepareStatement("DELETE FROM CustomersJSP WHERE ID = ?");
			Cdelete.setInt(1,id);
			int i = Cdelete.executeUpdate();
			if(i==1) {
				return true;
			}
		}
		catch(Exception E) {
			E.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean addCustomer(int id,String name,String location,String email) {
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(ConnectionURL,userName,passWord);
			PreparedStatement Cadd = con.prepareStatement("INSERT INTO CustomersJSP VALUES(?,?,?,?)");
			Cadd.setInt(1,id);
			Cadd.setString(2,name);
			Cadd.setString(3,location);
			Cadd.setString(4, email);
			int i = Cadd.executeUpdate();
			if(i==1) {
				return true;
			}
		}
		catch(Exception E) {
			E.printStackTrace();
			return false;
		}
		return true;
	}
}