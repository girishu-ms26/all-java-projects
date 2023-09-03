package com.bankproject.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Allbankoperations {
	
	public boolean authenticateBankuser(String userName,String passWord) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery("SELECT * FROM Bankusers");			
			while(rs.next()) {
				if(rs.getString(2).equals(userName)) {
					if(rs.getString(3).equals(passWord)) {
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
	public boolean registerBankuser(int accountNumber,String userName,String passWord) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			
			PreparedStatement Reguser = con.prepareStatement("INSERT INTO Bankusers VALUES (?,?,?)");
			Reguser.setInt(1,accountNumber);
			Reguser.setString(2,userName);
			Reguser.setString(3,passWord);
			PreparedStatement Bacc = con.prepareStatement("INSERT INTO Bacc VALUES (?,?,?)");
			Bacc.setInt(1, accountNumber);
			Bacc.setString(2,userName);
			Bacc.setDouble(3, 0);			
			int i = Reguser.executeUpdate();
			int j = Bacc.executeUpdate();
			if(i==1 && i == j) {
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
	public boolean contactUs(String userName,long phNo,String eMail,String uProblem) {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			
			PreparedStatement Contactus = con.prepareStatement("INSERT INTO ContactUs VALUES(?,?,?,?)");
			
			Contactus.setString(1,userName);
			Contactus.setLong(2, phNo);
			Contactus.setString(3, eMail);
			Contactus.setString(4,uProblem);
			int i = Contactus.executeUpdate();
			if(i==1) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception E) {
			E.printStackTrace();
			return false;
		}
	}
	public boolean depositAmount(String userName,int accountNo,double amount) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement D1 = con.prepareStatement("select * from bacc WHERE AccountNo = ?");
			D1.setInt(1, accountNo);
			ResultSet rs = D1.executeQuery();
			while(rs.next()) {
				if(accountNo==rs.getInt(1)) {
					if(userName.equals(rs.getString(2))) {
						double newbalance=rs.getDouble(3);
						newbalance=newbalance+amount;					
						PreparedStatement D2 = con.prepareStatement("UPDATE Bacc SET Balance = ? WHERE AccountNo = ?");	
						PreparedStatement D3 = con.prepareStatement("INSERT INTO alltrans VALUES(?,?,?,?,?)");	
						D2.setDouble(1, newbalance);
						D2.setInt(2,accountNo);
						D3.setInt(1, accountNo);D3.setString(2, userName);D3.setString(3,"D");D3.setDouble(4,amount);D3.setString(5,"SUCCESS");
						int i = D2.executeUpdate() + D3.executeUpdate();	
						if(i==2) {
							return true;
						}
					}
				}
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return false;
	}
	
	public boolean withdrawAmount(String userName,int accountNo,double amount){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement W1 = con.prepareStatement("select * from bacc WHERE AccountNo = ?");
			W1.setInt(1, accountNo);
			ResultSet rs = W1.executeQuery();
			while(rs.next()) {
				if(accountNo==rs.getInt(1)) {
					if(userName.equals(rs.getString(2))) {
						double newbalance=rs.getDouble(3);
						newbalance=newbalance-amount;	
						if(newbalance>0) {
							PreparedStatement W2 = con.prepareStatement("UPDATE Bacc SET Balance = ? WHERE AccountNo = ?");	
							PreparedStatement W3 = con.prepareStatement("INSERT INTO alltrans VALUES(?,?,?,?,?)");	
							W2.setDouble(1, newbalance);
							W2.setInt(2,accountNo);
							W3.setInt(1, accountNo);W3.setString(2, userName);W3.setString(3,"W");W3.setDouble(4,amount);W3.setString(5,"SUCCESS");
							int i = W2.executeUpdate() + W3.executeUpdate();
							if(i==2) {
								return true;
							}
						}
						else {
							PreparedStatement W4 = con.prepareStatement("INSERT INTO alltrans VALUES(?,?,?,?,?)");	
							W4.setInt(1, accountNo);W4.setString(2, userName);W4.setString(3,"W");W4.setDouble(4,amount);W4.setString(5,"FAILURE");
							W4.execute();
							return false;
						}
					}
				}
			}
		}
		catch(Exception E) {
			E.printStackTrace();
			return false;
		}
		return false;
	}
	public boolean transferAmount(String userName,int FaccountNumber,int TaccountNumber,double amount){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement F1 = con.prepareStatement("select * from bacc WHERE AccountNo = ?");
			F1.setInt(1, FaccountNumber);
			ResultSet rs0 = F1.executeQuery();
			
			PreparedStatement T1 = con.prepareStatement("select * from bacc WHERE AccountNo = ?");
			T1.setInt(1, TaccountNumber);
			ResultSet rs1 = T1.executeQuery();
			
			while(rs0.next()) {
				rs1.next();
				if(rs0.getDouble(3)>=amount) {
					double Fbalance=rs0.getDouble(3)-amount;
					double Tbalance=rs1.getDouble(3)+amount;
					PreparedStatement F2 = con.prepareStatement("UPDATE Bacc SET Balance = ? WHERE AccountNo = ?");
					PreparedStatement T2 = con.prepareStatement("UPDATE Bacc SET Balance = ? WHERE AccountNo = ?");
					PreparedStatement TT = con.prepareStatement("INSERT INTO alltrans VALUES(?,?,?,?,?)");	
					F2.setDouble(1, Fbalance);F2.setInt(2, FaccountNumber);
					TT.setInt(1, FaccountNumber);TT.setString(2, userName);TT.setString(3,"T");TT.setDouble(4,amount);TT.setString(5,"SUCCESS");
					T2.setDouble(1, Tbalance);T2.setInt(2,TaccountNumber);
					F2.execute();
					TT.execute();
					T2.execute();
				}
				else {
					PreparedStatement TT = con.prepareStatement("INSERT INTO alltrans VALUES(?,?,?,?,?)");	
					TT.setInt(1, FaccountNumber);TT.setString(2, userName);TT.setString(3,"T");TT.setDouble(4,amount);TT.setString(5,"FAILURE");
					TT.execute();
				}
			}		
			while(rs1.next()) {
				double Tbalance=rs1.getDouble(3)+amount;
				PreparedStatement R2 = con.prepareStatement("UPDATE Bacc SET Balance = ? WHERE AccountNo = ?");
				R2.setDouble(1, Tbalance);R2.setInt(2,TaccountNumber);
				
			}
			return true;
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return false;
	}
	public boolean deleteAccount(String userName,int accountNumber,String passWord){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement Del1 = con.prepareStatement("DELETE FROM Bacc WHERE AccountNo = ?");
			Del1.setInt(1, accountNumber);
			Del1.execute();
			PreparedStatement Del2 = con.prepareStatement("DELETE FROM Bankusers WHERE AccountNo = ?");
			Del2.setInt(1, accountNumber);
			Del2.execute();
			return true;
		}
		catch(Exception E) {
			E.printStackTrace();
			return false;
		}
	} 
	public String accountDetails(String userName,int accountNumber,String passWord){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement Acc = con.prepareStatement("SELECT * FROM Bacc WHERE AccountNo = ?");
			Acc.setInt(1, accountNumber);
			ResultSet rs = Acc.executeQuery();
			rs.next();
				String Details = "Account No "+rs.getInt(1)+"\nUsername "+rs.getString(2)+"\nBalance "+rs.getDouble(3);
				return Details;
		} 
		catch(Exception E) {
			E.printStackTrace();
			return "User Not Found";
		}
	}
}