package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AcceptRejectLeaveDao;
import com.dao.ConsumedLeaveDao;
import com.dao.EmployeeDao;
import com.dao.EmployeeLeaveDao;
import com.model.ConsumedLeave;
import com.model.Employee;
import com.model.EmployeeLeave;
import com.model.ManagerLeaveView;

public class RejectLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
   		String slNo = request.getParameter("sid");
		String empId = request.getParameter("eid");
         AcceptRejectLeaveDao.RejectEmployeeLeave(Integer.parseInt(slNo));
     
         ManagerViewEmployeeController view = new ManagerViewEmployeeController();
         List<ManagerLeaveView> mngleaveview = view.getEmployeeLeaveList(empId);
         request.getSession().setAttribute("list", mngleaveview);
         response.sendRedirect("managerViewPage.jsp");
   	}	
}
