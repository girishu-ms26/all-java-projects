package com.mphasis.empoperationservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.empmodels.AllEmpOperations;

/**
 * Servlet implementation class AddempServlet
 */
@WebServlet("/AddempServlet")
public class AddempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Empno =  Integer.parseInt((String) request.getParameter("empno"));
		String Ename = request.getParameter("ename");
		String Job = request.getParameter("job");
		int Mgr = Integer.parseInt((String) request.getParameter("mgr"));
		String Hiredate =  request.getParameter("hiredate");		
		double Sal = Double.parseDouble((String) request.getParameter("sal"));
		double Comm = Double.parseDouble((String) request.getParameter("comm"));
		int Deptno = Integer.parseInt((String) request.getParameter("deptno"));
		
		AllEmpOperations Add = new AllEmpOperations();
		
		boolean result = Add.addEmp(Empno,Ename,Job,Mgr,Hiredate,Sal,Comm,Deptno);
		
		if(result==true) {
			response.sendRedirect("SuccessOperation.html");
		}
		else {
			response.sendRedirect("FailureAction.html");
		}
	}

}
