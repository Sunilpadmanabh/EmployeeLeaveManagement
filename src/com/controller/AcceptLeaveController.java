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
import javax.servlet.http.HttpSession;

import com.dao.AcceptRejectLeaveDao;
import com.dao.ConsumedLeaveDao;
import com.dao.EmployeeDao;
import com.dao.EmployeeLeaveDao;
import com.model.ConsumedLeave;
import com.model.Employee;
import com.model.EmployeeLeave;
import com.model.ManagerLeaveView;
public class AcceptLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String slNo = request.getParameter("sid");
		String employeeId = request.getParameter("eid");
		String askedDays = request.getParameter("days");
		String leaveType = request.getParameter("type");
				
		  
      int status = AcceptRejectLeaveDao.approveEmployeeLeave(Integer.parseInt(slNo));
       int total = AcceptRejectLeaveDao.updateConsumedLeave(employeeId,Integer.parseInt(askedDays),leaveType);
          status = AcceptRejectLeaveDao.updateTotalLeave(employeeId,Integer.parseInt(askedDays),leaveType);
                   AcceptRejectLeaveDao.myChanges(total,Integer.parseInt(slNo),leaveType);
          if(status>0)
            {
		       ManagerViewEmployeeController view = new ManagerViewEmployeeController();
		       List<ManagerLeaveView> mngleavelist = view.getEmployeeLeaveList(employeeId);
			   request.getSession().setAttribute("list", mngleavelist);
//			   response.sendRedirect("managerPage.jsp");
			   response.sendRedirect("managerViewPage.jsp");
            }		 
	}
}

