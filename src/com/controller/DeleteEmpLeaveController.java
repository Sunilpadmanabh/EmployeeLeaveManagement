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
public class DeleteEmpLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	  int slno = Integer.parseInt(request.getParameter("did"));
	  String empId = request.getParameter("deid");
	  int status = EmployeeLeaveDao.deleteEmployeeLeaveBySlNo(slno);
	  HttpSession session = request.getSession();
	  if(status>0)
	  {
		 session.setAttribute("messageSession", "EmployeeLeaveRequest Deleted!");
		   List<EmployeeLeave> list = EmployeeLeaveDao.getEmployeeLeaveById(empId);
		   
		   if(list!=null)
		   {
			      session.setAttribute("list", list);
				  response.sendRedirect("employeeLeaveViewPage.jsp");
		   }
	  }
	  else
	  {
		  response.sendRedirect("errorPage.jsp");
	  }
	}

}
