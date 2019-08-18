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

public class UpdateEmpLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  String slno = request.getParameter("slno");
	  String empId = request.getParameter("empId");
	  
	  String datefrom = request.getParameter("datefrom");
	  String dateto = request.getParameter("dateto");
	  String leavetype = request.getParameter("leavetype");
	  String descp = request.getParameter("descp");
	  
	  EmployeeLeave empleave = new EmployeeLeave();
	  empleave.setSlNo(Integer.parseInt(slno));
	  empleave.setDateFrom(datefrom);
	  empleave.setDateto(dateto);
	  empleave.setLeaveType(leavetype);
	  empleave.setDescp(descp);
	  

	  if(!datefrom.isEmpty() && !dateto.isEmpty() && !descp.isEmpty())
	  {
		  int status = EmployeeLeaveDao.updateEmployeeLeave(empleave);

		  HttpSession session = request.getSession();
	  	  if(status>0)
	  	  {
	  		        session.setAttribute("messageSession", "Successfully Updated!");
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
	  else
	  {
		  request.getSession().setAttribute("messageSession", "Please fill the details!");
          response.sendRedirect("editLeavePage.jsp");
	  }
  }
}
