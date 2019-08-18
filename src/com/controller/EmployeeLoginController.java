package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
import com.dao.ManagerDao;
import com.model.Employee;
import com.model.ManagerLeaveView;

public class EmployeeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
				String emailId = request.getParameter("emailId");
				String password = request.getParameter("password");
				String radiobtn = request.getParameter("radiobtn");
				
				Employee employee = EmployeeDao.validationOfLogin(emailId,password);
				HttpSession session = request.getSession();
				if(employee!= null && radiobtn.equals("employee") && employee.isManager()==false)
				{
					session.setAttribute("loginSession", employee);
					response.sendRedirect("employeeLeavePage.jsp");
				}
				else if(employee!=null && radiobtn.equals("manager") && employee.isManager()==true)
				{
				    	List<ManagerLeaveView> list = ManagerDao.getLeaveRequestList();
				    	List<ManagerLeaveView> newlist = new ArrayList<ManagerLeaveView>();
				    	for(ManagerLeaveView employe : list)
				    	{
				    		boolean b = ManagerDao.checkPendingLeaves(employe.getEmployeeId());
				    		if(b)
				    		{
				    			employe.setStatus("pending");
				    		}
				    		else
				    		{
				    			employe.setStatus("approved");
				    		}
				    	        newlist.add(employe);	
				    		
				    	}
				    	 session.setAttribute("list", newlist);
					     response.sendRedirect("managerPage.jsp");
				}
				else
				{
					session.setAttribute("messageSession", "Please Provide Valid Credentials!");
					response.sendRedirect("loginPage.jsp");
				}
				
	}

}
