package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConsumedLeaveDao;
import com.dao.EmployeeDao;
import com.model.Employee;
import com.mysql.cj.Session;

public class EmployeeRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 String EmpId = request.getParameter("id");
		 String EmpName = request.getParameter("name");
		 String EmpEmailId = request.getParameter("emailId");
		 String EmpPassword = request.getParameter("password");
		 String EmpDepartment = request.getParameter("selectdept");
		  Employee employee = new Employee();
		  employee.setEmployeeId(EmpId);
		  employee.setName(EmpName);
		  employee.setEmailId(EmpEmailId);
		  employee.setPassword(EmpPassword);
		  employee.setDept(EmpDepartment);
		    int status = EmployeeDao.insertEmployee(employee);
		    status = ConsumedLeaveDao.insertEmployee(employee.getEmployeeId());
		    HttpSession session = request.getSession();
		 if(status>0)
		 {
			 session.setAttribute("messageSession", "Successfully Registered!");
			 response.sendRedirect("loginPage.jsp");
		 }
		 else
		 {
			 session.setAttribute("messageSession", "Not Registered!");
			 response.sendRedirect("errorPage.jsp");
		 }
	}

}
