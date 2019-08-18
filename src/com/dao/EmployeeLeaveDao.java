package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.EmployeeLeave;

public class EmployeeLeaveDao 
{
	static Connection con;

	public static int insertEmployeeLeave(EmployeeLeave eleave)
	{
		int status = 0;
		con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into employeeleave (employeeId,name,emailId,dept,datefrom,dateto,leavetype,descp) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, eleave.getEmployeeId());
			ps.setString(2, eleave.getName());
			ps.setString(3, eleave.getEmailId());
			ps.setString(4, eleave.getDept());
			ps.setString(5, eleave.getDateFrom());
			ps.setString(6, eleave.getDateto());
			ps.setString(7, eleave.getLeaveType());
			ps.setString(8, eleave.getDescp());
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
   	}

	public static List<EmployeeLeave> getEmployeeLeaveById(String empId)
	{
		// TODO Auto-generated method stub
		con =  DBConnection.getConnection();
		List<EmployeeLeave> list = new ArrayList<EmployeeLeave>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from employeeleave where employeeId="+empId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmployeeLeave empleave = new EmployeeLeave();

				empleave.setSlNo(rs.getInt(1));
				empleave.setEmployeeId(rs.getString(2));
				empleave.setName(rs.getString(3));
				empleave.setEmailId(rs.getString(4));
				empleave.setDept(rs.getString(5));
				empleave.setDateFrom(rs.getString(6));
				empleave.setDateto(rs.getString(7));
				empleave.setLeaveType(rs.getString(8));
				empleave.setDescp(rs.getString(9));
				empleave.setStatus(rs.getString(10));
				list.add(empleave);
				
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
		return list;
		
	}

	public static EmployeeLeave getEmployeeLeaveBySlNo(String slno) 
	{
		// TODO Auto-generated method stub
		EmployeeLeave empleave = new EmployeeLeave();
		con = DBConnection.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement("select * from employeeleave where slNo="+slno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				empleave.setSlNo(rs.getInt(1));
				empleave.setEmployeeId(rs.getString(2));
				empleave.setName(rs.getString(3));
				empleave.setEmailId(rs.getString(4));
				empleave.setDept(rs.getString(5));
				empleave.setDateFrom(rs.getString(6));
				empleave.setDateto(rs.getString(7));
				empleave.setLeaveType(rs.getString(8));
				empleave.setDescp(rs.getString(9));
				empleave.setStatus(rs.getString(10));
				
				
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
		return empleave;
		
	}

	public static int updateEmployeeLeave(EmployeeLeave empleave) 
	{
		int status = 0;
		// TODO Auto-generated method stub
		con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update EmployeeLeave set datefrom=?, dateto=?, leavetype=?, descp=? where slNo=?");
			ps.setString(1, empleave.getDateFrom());
			ps.setString(2, empleave.getDateto());
			ps.setString(3, empleave.getLeaveType());
			ps.setString(4, empleave.getDescp());
			ps.setInt(5, empleave.getSlNo());
		  status = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

	public static int deleteEmployeeLeaveBySlNo(int slno)
	{
		int status = 0;
		// TODO Auto-generated method stub
		con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from employeeleave where slNo="+slno);
		    status = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
	
}
