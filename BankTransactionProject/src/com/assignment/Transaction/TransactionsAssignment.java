package com.assignment.Transaction;

import java.sql.*;

public class TransactionsAssignment {
	public static void main(String[]args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			//Statement st1 = con.createStatement();
			PreparedStatement sws = con.prepareStatement("SELECT * FROM BankTrans");
			ResultSet rs=sws.executeQuery();
			while(rs.next()){
				rs.getString(1);rs.getInt(2);rs.getDouble(3);rs.getString(4);
				rs.getDouble(5);rs.getDouble(6);rs.getString(7);
				if(rs.getString(4).equals("W") && rs.getDouble(5)>rs.getDouble(3)) {
					PreparedStatement swe= con.prepareStatement("INSERT INTO invalidTrans VALUES(?,?,?,?)");
					swe.setString(1,rs.getString(1));
					swe.setString(2,rs.getString(4));
					swe.setDouble(3,rs.getDouble(5));
					swe.setString(4,"InValid");
					swe.execute();					
				}
				if(rs.getString(4).equals("W") && rs.getDouble(5)<=rs.getDouble(3)) {
										
					PreparedStatement sw = con.prepareStatement("UPDATE BankTrans SET NewBal = ? WHERE TransID = ?");
					sw.setString(2, rs.getString(1));
					sw.setDouble(1,rs.getDouble(3)-rs.getDouble(5));
					sw.execute();
					
					PreparedStatement swi = con.prepareStatement("INSERT INTO validTrans VALUES(?,?,?,?)");
					swi.setString(1,rs.getString(1));
					swi.setString(2,rs.getString(4));
					swi.setDouble(3,rs.getDouble(5));
					swi.setString(4,"Valid");
					swi.execute();
				}
				if(rs.getString(4).equals("D")) {
					
					PreparedStatement sw = con.prepareStatement("UPDATE BankTrans SET NewBal = ? WHERE TransID = ?");
					sw.setString(2,rs.getString(1));
					sw.setDouble(1,rs.getDouble(3)+rs.getDouble(5));
					sw.execute();
					
					PreparedStatement sww = con.prepareStatement("INSERT INTO validTrans VALUES(?,?,?,?)");
					sww.setString(1,rs.getString(1));
					sww.setString(2,rs.getString(4));
					sww.setDouble(3,rs.getDouble(5));
					sww.setString(4,"Valid");
					sww.execute();
				}
			}
			con.close();
		}
		catch(Exception E) {
			E.printStackTrace();
		}
	}
}