package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.model.Employee;

public class EmployeeDao 
{
	static Connection con;
	public static int insertEmployee(Employee employee)
	{
		int status = 0;
		con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee (employeeId,name,emailId,password,dept) values (?,?,?,?,?)");
			ps.setString(1, employee.getEmployeeId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getEmailId());
			ps.setString(4, employee.getPassword());
			ps.setString(5, employee.getDept());
		status = ps.executeUpdate();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static Employee validationOfLogin(String emailId, String password) 
	{
		// TODO Auto-generated method stub
		con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select employeeId,name,dept,isManager from employee where emailId=? and password=?");
		    ps.setString(1, emailId);
		    ps.setString(2, password);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next())
		    {
		    		String id = rs.getString(1);
			    	String name = rs.getString(2);
			    	String dept = rs.getString(3);
			    	boolean isManager = rs.getBoolean(4);
			    	 Employee employee = new Employee();
			    	 employee.setEmployeeId(id);
			    	 employee.setName(name);
			    	 employee.setEmailId(emailId);
			    	 employee.setDept(dept);
			    	 employee.setManager(isManager);
			    	 con.close();
			    	return employee;
		    	
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public static Employee getEmployeeById(String id) 
	{
		Employee employee = new Employee();
		con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select name,emailId,dept,holiday,planned,medical,isManager from employee where employeeId="+id);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 employee.setEmployeeId(id);
				 employee.setName(rs.getString(1));
				 employee.setEmailId(rs.getString(2));
				 employee.setDept(rs.getString(3));
				 employee.setHoliday(rs.getInt(4));
				 employee.setPlanned(rs.getInt(5));
				 employee.setMedical(rs.getInt(6));
				 employee.setManager(rs.getBoolean(7));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		
	}

}
