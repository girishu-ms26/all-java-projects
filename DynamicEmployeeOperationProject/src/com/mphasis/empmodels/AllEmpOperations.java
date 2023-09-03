package com.mphasis.empmodels;

import java.sql.*;

public class AllEmpOperations{

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
			return false;
		}
		return false;
	}
	
	public boolean addEmp(int Empno,String Ename,String Job,int Mgr,String Hiredate,double Sal,double Comm,int Deptno) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			
			PreparedStatement Addemp = con.prepareStatement("INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)");	
			
			Addemp.setInt(1,Empno); Addemp.setString(2,Ename); Addemp.setString(3,Job);
			Addemp.setInt(4,Mgr);Addemp.setString(5, Hiredate); Addemp.setDouble(6,Sal);
			Addemp.setDouble(7,Comm); Addemp.setInt(8,Deptno);
			
			System.out.println();
			int i = Addemp.executeUpdate();		
			if(i==1) {
				return true;
			}
			
		}
		catch(Exception E) {
			E.printStackTrace();
			return false;
		}
		return false;
	}
	
	public String dispEmp(int Empno) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			
			PreparedStatement Dispemp = con.prepareStatement("SELECT * FROM EMP WHERE EMPNO = ?");			
			Dispemp.setInt(1,Empno);
			int i = Dispemp.executeUpdate();
			ResultSet rs= Dispemp.executeQuery(); 
			while(rs.next()) {			
				
				String emp = "EmpNo: "+rs.getInt(1)+"\nEmp Name: "+rs.getString(2)+"\nJob: "+rs.getString(3)+"\nMgr: "+rs.getInt(4)+"\nHireDate: "+rs.getDate(5)+"\nSal: "+rs.getString(6)+"\nComm: "+rs.getDouble(7)+"\nDeptno: "+rs.getInt(8);
				if(i==1) {
				return emp;
				}			
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return "Employee NOT Found";
	}
	public boolean updateEmp(int Empno,String Ename,String Job,int Mgr,String Hiredate,double Sal,double Comm,int Deptno) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			
			PreparedStatement UpdateEmp = con.prepareStatement("UPDATE emp SET ename = ?,job = ?,mgr = ?,hiredate = ?,sal = ?,comm = ?,deptno = ? WHERE Empno = ?");	
			
			UpdateEmp.setString(1,Ename); UpdateEmp.setString(2,Job); UpdateEmp.setInt(3,Mgr);
			UpdateEmp.setString(4,Hiredate);UpdateEmp.setDouble(5, Sal); UpdateEmp.setDouble(6,Comm);
			UpdateEmp.setDouble(7,Deptno); UpdateEmp.setInt(8,Empno);
			
			System.out.println();
			int i = UpdateEmp.executeUpdate();		
			if(i==1) {
				return true;
			}
			
		}
		catch(Exception E) {
			E.printStackTrace();
			return false;
		}
		return false;
	}
	public boolean deleteEmp(int Empno) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement DeleteEmp = con.prepareStatement("DELETE FROM emp WHERE Empno = ?");
			DeleteEmp.setInt(1, Empno);
			int i = DeleteEmp.executeUpdate();
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
}