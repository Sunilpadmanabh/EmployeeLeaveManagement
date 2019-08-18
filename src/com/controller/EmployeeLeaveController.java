package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
import com.dao.EmployeeLeaveDao;
import com.model.Employee;
import com.model.EmployeeLeave;

public class EmployeeLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 	{
 	   String id = request.getParameter("empid");
 	   System.out.println(id+"*************************************");
 	   Employee employee = EmployeeDao.getEmployeeById(id);
 	   String datefrom = request.getParameter("datefrom");
 	   String dateto = request.getParameter("dateto");
 	   String leavetype = request.getParameter("leavetype");
 	   String descp = request.getParameter("descp");
	   int totalDays = ManagerViewEmployeeController.getdaysinBetween(datefrom, dateto);

 	   EmployeeLeave eleave = new EmployeeLeave();
 	   eleave.setEmployeeId(employee.getEmployeeId());
 	   eleave.setName(employee.getName());
 	   eleave.setEmailId(employee.getEmailId());
 	   eleave.setDept(employee.getDept());
 	   eleave.setDateFrom(datefrom);
 	   eleave.setDateto(dateto);
 	   eleave.setLeaveType(leavetype);
 	   eleave.setDescp(descp); 
       HttpSession session = request.getSession();
 	    
 	    if(eleave.getDescp().isEmpty() || eleave.getDateFrom().isEmpty() || eleave.getDateto().isEmpty())
 	    {
 	    	session.setAttribute("messageSession", "Please fill the details!");
			 response.sendRedirect("employeeLeavePage.jsp");
 	    }

 	    else if(totalDays>20 && leavetype.equals("Planned") || totalDays>20 && leavetype.equals("Holiday") ||totalDays>20 && leavetype.equals("Medical"))
 	    {
 
	    	 session.setAttribute("messageSession", "Cannot Exceed more than 20 Leaves!");
			 response.sendRedirect("employeeLeavePage.jsp");
	     }
 	     
 	    else
 	    {
 	 	    int status = EmployeeLeaveDao.insertEmployeeLeave(eleave);
 	           if(status>0)
		         {
			       session.setAttribute("messageSession", "Leave Request Successfully Submitted!");
			       response.sendRedirect("employeeLeavePage.jsp");
	    	     }
		       else
		         {
			       session.setAttribute("messageSession", "Not Submitted");
			       response.sendRedirect("errorPage.jsp");
		         }
 	    }
	}

}
