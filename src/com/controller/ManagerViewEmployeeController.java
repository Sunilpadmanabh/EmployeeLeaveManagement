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

import com.dao.ConsumedLeaveDao;
import com.dao.EmployeeDao;
import com.dao.EmployeeLeaveDao;
import com.model.ConsumedLeave;
import com.model.Employee;
import com.model.EmployeeLeave;
import com.model.ManagerLeaveView;
public class ManagerViewEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String empId = request.getParameter("eid");
		List<ManagerLeaveView> mngleavelist = getEmployeeLeaveList(empId);
		 request.getSession().setAttribute("list", mngleavelist);
		 response.sendRedirect("managerViewPage.jsp");

	}

	public List<ManagerLeaveView> getEmployeeLeaveList(String empId)
	{
		 List<EmployeeLeave> list = EmployeeLeaveDao.getEmployeeLeaveById(empId);
		 List<ManagerLeaveView> mngleavelist = new ArrayList<ManagerLeaveView>();
		  for(EmployeeLeave leave:list)
		  {
			 Employee employee =  EmployeeDao.getEmployeeById(leave.getEmployeeId());
			    ConsumedLeave consumed_leave = ConsumedLeaveDao.getEmpLeaveByempId(empId);
			    ManagerLeaveView mngleaveview = new ManagerLeaveView();
			    mngleaveview.setSlNo(leave.getSlNo());
			    mngleaveview.setEmployeeId(employee.getEmployeeId());
			    mngleaveview.setName(employee.getName());
			    mngleaveview.setEmailId(employee.getEmailId());
			    mngleaveview.setDept(employee.getDept());
			    mngleaveview.setDateFrom(leave.getDateFrom());
			    mngleaveview.setDateto(leave.getDateto());		
			    mngleaveview.setLeaveType(leave.getLeaveType());
			    mngleaveview.setDescp(leave.getDescp());
			    mngleaveview.setStatus(leave.getStatus());
			    
			    if(leave.getLeaveType().equals("Planned"))
			    {
			    	mngleaveview.setTotal(employee.getPlanned());
			    	mngleaveview.setConsumed(consumed_leave.getConsumed_plannedLeave());
			    }
			    if(leave.getLeaveType().equals("Holiday"))
			    {
			    	mngleaveview.setTotal(employee.getHoliday());
			    	mngleaveview.setConsumed(consumed_leave.getConsumed_holidayLeave());
			    }
			    if(leave.getLeaveType().equals("Medical"))
			    {
			    	mngleaveview.setTotal(employee.getMedical());
			    	mngleaveview.setConsumed(consumed_leave.getConsumed_medicalLeave());
			    }
			    
			    int days=getdaysinBetween(leave.getDateFrom(),leave.getDateto());
				mngleaveview.setAskedDays(days);
			    mngleavelist.add(mngleaveview);    
			    
		  }
		return mngleavelist;

	}
		

	
	public static int getdaysinBetween(String firstInput,String secondInput) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        final LocalDate firstDate = LocalDate.parse(firstInput, formatter);
        final LocalDate secondDate = LocalDate.parse(secondInput, formatter);
        final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
        System.out.println("Days between: " + days);
        return (int)days+1;
    }
}
