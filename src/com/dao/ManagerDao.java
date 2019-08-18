package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.ManagerLeaveView;

public class ManagerDao
{
   static Connection con;
   
	public static List<ManagerLeaveView> getLeaveRequestList() 
	{
		List<ManagerLeaveView> list = new ArrayList<ManagerLeaveView>();
		// TODO Auto-generated method stub
		con = DBConnection.getConnection();
		try {
		PreparedStatement ps = con.prepareStatement("select distinct(employeeId),name,emailId,dept from employeeLeave");
//	PreparedStatement ps = con.prepareStatement("select slNo,employeeId,name,emailId,dept from employeeLeave");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ManagerLeaveView mngview = new ManagerLeaveView();
//				mngview.setSlNo(rs.getInt(1));
//				mngview.setEmployeeId(rs.getString(2));
//				mngview.setName(rs.getString(3));
//				mngview.setEmailId(rs.getString(4));
//				mngview.setDept(rs.getString(5));
				
				mngview.setEmployeeId(rs.getString(1));
				mngview.setName(rs.getString(2));
				mngview.setEmailId(rs.getString(3));
				mngview.setDept(rs.getString(4));
				
				list.add(mngview);
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

	public static boolean checkPendingLeaves(String employeeId)
	{
		// TODO Auto-generated method stub
		con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select status from employeeleave where employeeId=? and status='pending' ");
			ps.setString(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}
   
}
