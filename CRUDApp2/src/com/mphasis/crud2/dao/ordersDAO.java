package com.mphasis.crud2.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.crud2.entity.Order;


public class ordersDAO {
	
	String ConnectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
	String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	String userName = "scott";
	String passWord = "tiger";
	
	public boolean authenticateUser(String userName,String passWord) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
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
	
	public List<Order> getOrders(){
		List<Order> Orders = new ArrayList<Order>();
		
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(ConnectionURL,userName,passWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM  Crudorders");
			while(rs.next()) { 
				Order O = new Order();
				O.setOnum(rs.getInt(1));
				O.setOdate(rs.getDate(2));
				O.setAmount(rs.getDouble(3));
				O.setCnum(rs.getInt(4));
				O.setSnum(rs.getInt(5));
				Orders.add(O);
			}
			con.close();
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return Orders;
	}
	public boolean updateOrder(int onum,String odate,double amount,int cnum,int snum) {
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(ConnectionURL,userName,passWord);
			PreparedStatement Oupdate = con.prepareStatement("UPDATE Crudorders SET ODATE = ?,AMT = ?,CNUM = ?,SNUM = ? WHERE ONUM = ?");
			
			Oupdate.setString(1, odate);
			Oupdate.setDouble(2, amount);
			Oupdate.setInt(3,cnum);
			Oupdate.setInt(4,snum);
			Oupdate.setInt(5, onum);
			int i = Oupdate.executeUpdate();
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
	public boolean deleteOrder(int onum) {
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(ConnectionURL,userName,passWord);
			PreparedStatement Odelete = con.prepareStatement("DELETE FROM Crudorders WHERE ONUM = ?");
			Odelete.setInt(1,onum);
			int i = Odelete.executeUpdate();
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
	public boolean addOrder(int onum,String odate,double amount,int cnum,int snum) {
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(ConnectionURL,userName,passWord);
			PreparedStatement Oadd = con.prepareStatement("INSERT INTO Crudorders VALUES(?,?,?,?,?)");
			Oadd.setInt(1, onum);
			Oadd.setString(2, odate);
			Oadd.setDouble(3,amount);
			Oadd.setInt(4,cnum);
			Oadd.setInt(5, snum);
			int i = Oadd.executeUpdate();
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















