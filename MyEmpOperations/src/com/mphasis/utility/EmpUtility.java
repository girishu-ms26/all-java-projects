package com.mphasis.utility;

import java.util.ArrayList;

import com.mphasis.entity.Emp;

public class EmpUtility {

	public void getEmployees(ArrayList<Emp> employees) {
		//Enhanced Forloop
		for(Emp employee : employees) {
			System.out.println(employee.getEmpno()
								+ "  " +employee.getEname()
								+ "  " +employee.getJob()
								+ "  " +employee.getMgr()
								+ "  " +employee.getHiredate()
								+ "  " +employee.getSal()
								+ "  " +employee.getComm()
								+ "  " +employee.getDeptno());
			
			
			/*System.out.println(employee.getEname());
			System.out.println(employee.getJob());
			System.out.println(employee.getMgr());
			System.out.println(employee.getSal());
			System.out.println(employee.getComm());
			System.out.println(employee.getDeptno());*/
		}
	}
	
}
