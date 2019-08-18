package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeLeaveDao;
import com.model.EmployeeLeave;

public class EmployeeLeaveViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String empId = request.getParameter("vempid");
		List<EmployeeLeave> empleavelist = EmployeeLeaveDao.getEmployeeLeaveById(empId);
		HttpSession session = request.getSession();
		
		if(empleavelist!=null)
		{
			session.setAttribute("list", empleavelist);
			response.sendRedirect("employeeLeaveViewPage.jsp");
		}
		else
		{
			response.sendRedirect("errorPage.jsp");
		}
	}

}
