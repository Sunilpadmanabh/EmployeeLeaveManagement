package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeLeaveDao;
import com.model.EmployeeLeave;

public class EditEmpLeaveController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   String slno = request.getParameter("eid");
	   String empId = request.getParameter("eeid");
	   
	   EmployeeLeave empleave = EmployeeLeaveDao.getEmployeeLeaveBySlNo(slno); 
	   request.getSession().setAttribute("editSession", empleave);
	   request.getSession().setAttribute("editempId", empId);
	   response.sendRedirect("editLeavePage.jsp");
	}
}
