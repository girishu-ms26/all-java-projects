package com.assignment.accountaction;

import java.sql.*;

public class accountaction {
	
	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connecting with oracle server using its driver
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");	
			
			Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);			
			
			ResultSet rs0 = st1.executeQuery("SELECT * FROM AccountsTable");
			ResultSet rs1 = st2.executeQuery("SELECT * FROM ActionTable");			
			
			//iterating through all the rows in the table
			while(rs1.next()) {	
				//Moving the cursor of Resultset 0 back to the Initial position every time before it enters back into nested whileloop.
				//It is to compare all the rows of one table with other table.
				rs0.beforeFirst();					
			
				while(rs0.next()) {							
				
					if(rs1.getString(2).equals("u")) {						
						if(rs1.getInt(1)==rs0.getInt(1)) {							
							PreparedStatement u = con.prepareStatement("UPDATE AccountsTable SET Bal = ? WHERE AccountID = ?");
							PreparedStatement u1 = con.prepareStatement("UPDATE ActionTable SET Status = 'Update: Success' WHERE AccountID = ?");								
							u.setDouble(1,rs1.getDouble(3));
							u.setInt(2,rs1.getInt(1));							
							u1.setInt(1,rs1.getInt(1));							
							u.execute();							
							u1.execute();
						}	
						
						if(rs1.getInt(1)!=rs0.getInt(1)) {							
							try {								
								PreparedStatement u2 = con.prepareStatement("INSERT INTO AccountsTable VALUES(?,?)");
								PreparedStatement u3 = con.prepareStatement("UPDATE ActionTable SET Status = 'Update: ID not Found, Value Inserted' WHERE AccountID = ?");								
								u2.setInt(1,rs1.getInt(1));
								u2.setDouble(2,rs1.getDouble(3));								
								u3.setInt(1,rs1.getInt(1));								
								u2.execute();								
								u3.execute();	
							}
							catch(Exception E) {
								continue;
							}
						}
					}
					
					if(rs1.getString(2).equals("i")) {
						try {
							if(rs1.getInt(1)!=rs0.getInt(1)) {
								PreparedStatement i = con.prepareStatement("INSERT INTO AccountsTable VALUES (?,?)");
								PreparedStatement i1 = con.prepareStatement("UPDATE ActionTable SET Status = 'Insert: Success' WHERE AccountID = ?");
								i.setInt(1,rs1.getInt(1));
								i.setDouble(2,rs1.getDouble(3));
								i1.setInt(1,rs1.getInt(1));
								i.execute();
								i1.execute();
							}
						}
						catch(Exception E) {
							continue;
						}
						
						if(rs1.getInt(1)==rs0.getInt(1)) {
							try {
								PreparedStatement i2 = con.prepareStatement("UPDATE ActionTable SET Status = 'Insert: Acc Exists, Updated Instead' WHERE AccountID = ?");
								PreparedStatement i3 = con.prepareStatement("UPDATE AccountsTable SET AccountID = ?,Bal = ? WHERE AccountID = ?");
								i2.setInt(1,rs1.getInt(1));
								i3.setInt(1,rs1.getInt(1));
								i3.setDouble(2,rs1.getDouble(3));
								i3.setInt(3,rs1.getInt(1));
								i2.execute();
								i3.execute();
							}
							catch(Exception E) {
								continue;
							}
						}
					}
					
					if(rs1.getString(2).equals("d")) {
						if(rs1.getInt(1)==rs0.getInt(1)) {
							PreparedStatement d = con.prepareStatement("UPDATE ActionTable SET STATUS = 'Delete: Success' WHERE AccountID = ?");
							PreparedStatement d1 = con.prepareStatement("DELETE FROM AccountsTable WHERE AccountID = ?");								
							d.setInt(1,rs1.getInt(1));
							d1.setInt(1,rs1.getInt(1));
							d.execute();
							d.execute();
							d1.execute();							
						}
						if(rs1.getInt(1)!=rs0.getInt(1)) {
							PreparedStatement d2 = con.prepareStatement("UPDATE ActionTable SET STATUS = 'Delete: ID not found' WHERE AccountID = ?");
							d2.setInt(1,rs1.getInt(1));				
							d2.execute();							
						}
					}
					
					if(!rs1.getString(2).equals("u") && !rs1.getString(2).equals("i") && !rs1.getString(2).equals("d")) {
						PreparedStatement x = con.prepareStatement("UPDATE ActionTable SET STATUS = 'Invalid Operation, No action taken' WHERE AccountID = ?");
						x.setInt(1,rs1.getInt(1));
						x.execute();
					}
				}
			}
			con.close();
		}
		catch(Exception E) {
			E.printStackTrace();
		}
	}
}