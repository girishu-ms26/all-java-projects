package com.mphasisjdbccodes;
import java.sql.*;

public class JdbcCon {
	public static void main(String[]args) {
		
		try {		
			//loading JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			//Establishing connection with database
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
		
			//Creating the statement object
			Statement stmt = con.createStatement();
		
			//executing the Query
			ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
		
			while(rs.next()) {
				int mempno = rs.getInt(1);
				String mename = rs.getString(2);
				String mjob = rs.getString(3);
				int mgr = rs.getInt(4);			
				Date HireDate = rs.getDate(5);
				double Sal = rs.getDouble(6);
				double Comm = rs.getDouble(7);
				int Deptno = rs.getInt(8);
			
				System.out.println(mempno+" "+mename+" "+mjob+" "+mgr+" "+HireDate+" "+Sal+" "+Comm+" "+Deptno);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}