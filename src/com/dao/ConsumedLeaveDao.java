package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.ConsumedLeave;

public class ConsumedLeaveDao
{
    static Connection con;
    
	public static ConsumedLeave getEmpLeaveByempId(String empId) 
	{
		ConsumedLeave con_leave = new ConsumedLeave();
		// TODO Auto-generated method stub
		con = DBConnection.getConnection();
		try {			 
			PreparedStatement ps = con.prepareStatement("select * from consumedleave where employeeId="+empId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				con_leave.setEmployeeId(rs.getString(1));
				con_leave.setConsumed_plannedLeave(rs.getInt(2));
				con_leave.setConsumed_holidayLeave(rs.getInt(3));
				con_leave.setConsumed_medicalLeave(rs.getInt(4));
								
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
		return con_leave;
		
		
	}
	public static int insertEmployee(String employeeId)
	{
		int status = 0;
		// TODO Auto-generated method stub
		con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into consumedleave (employeeId) values(?) ");
			ps.setString(1, employeeId);
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
