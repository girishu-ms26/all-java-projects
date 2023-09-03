package com.mphasis.empdemo;

import java.util.ArrayList;
import java.sql.*;
import com.mphasis.entity.Emp;



public class TestEmp {
	public static void main(String[]args) {	
		/*
		Emp E1 = new Emp(7369,"SMITH","CLERK",7902,1152,500,20);
		employees.add(E1);
		Emp E2 = new Emp(7499,"ALLEN","SALESMAN",7698,1760,300,30);
		employees.add(E2);
		Emp E3 = new Emp(7521,"WARD","SALESMAN",7698,1250,500,30);
		employees.add(E3);
		Emp E4 = new Emp(7566,"Sachin","MANAGER",7839,2975,0,20);
		employees.add(E4);
		Emp E5 = new Emp(7654,"MARTIN","CLERK",7698,1250,1400,30);
		employees.add(E5);
		*/
		
		/* try {
			ArrayList<Emp> employees = new ArrayList<Emp>();
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
		
			while(rs.next()) {
				int mempno = rs.getInt(1);String mename = rs.getString(2);String mjob = rs.getString(3);int mmgr = rs.getInt(4);			
				Date hiredate = rs.getDate(5);double Sal = rs.getDouble(6);double Comm = rs.getDouble(7);int Deptno = rs.getInt(8);
				
				employees.add(new Emp(mempno,mename,mjob,mmgr,hiredate,Sal,Comm,Deptno));		
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		finally {
			System.out.println("Empno  Ename  Job  Mgr  HireDate  Sal  Comm  Deptno");
			for(Emp employee : employees) {
				System.out.println(employee.getEmpno()
						+ "  " +employee.getEname()
						+ "  " +employee.getJob()
						+ "  " +employee.getMgr()
						+ "  " +employee.getHiredate()
						+ "  " +employee.getSal()
						+ "  " +employee.getComm()
						+ "  " +employee.getDeptno());
			}
			//EmpUtility utility = new EmpUtility();
			//utility.getEmployees(employees);			
		}*/
		try {
			ArrayList<Emp> employees = new ArrayList<Emp>();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
		
			while(rs.next()) {
				Emp myEmp = new Emp();
				myEmp.setEmpno(rs.getInt(1));
				myEmp.setEname(rs.getString(2));
				myEmp.setJob(rs.getString(3));
				myEmp.setMgr(rs.getInt(4));
				myEmp.setHiredate(rs.getDate(5));
				myEmp.setSal(rs.getDouble(6));
				myEmp.setComm(rs.getDouble(7));
				myEmp.setDeptno(rs.getInt(8));
				employees.add(myEmp);			
			}
			//EmpUtility utility = new EmpUtility();
			//utility.getEmployees(employees);
			for(int i=0;i<=3;i++) {
				System.out.println(employees);
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		
	}
}