package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.EmployeeLeave;

public class AcceptRejectLeaveDao 
{
	static Connection con;
	
	public static int approveEmployeeLeave(int slNo)
	{
		// TODO Auto-generated method stub
	    int status = 0;
        con = DBConnection.getConnection();
        try {
			PreparedStatement ps = con.prepareStatement("update employeeleave set status='approved' where slNo=? ");
			ps.setInt(1, slNo);
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
	
	public static int updateConsumedLeave(String employeeId, int askedDays, String leaveType)
	{
		int total = 0;
		// TODO Auto-generated method stub
		con = DBConnection.getConnection();
		int status = 0;
		try {
		if(leaveType.equals("Planned"))
		{
			PreparedStatement ps=con.prepareStatement("select consumed_plannedLeave from consumedleave where employeeId=?");
			ps.setString(1,employeeId );
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int planned=res.getInt(1);
				total=planned+askedDays;
			}
			 ps=con.prepareStatement("update consumedleave set consumed_plannedLeave=? where employeeId=?");
			 ps.setInt(1, total);
			 ps.setString(2, employeeId);
			 status = ps.executeUpdate();
			
		}
		if(leaveType.equals("Holiday"))
		{
			PreparedStatement ps=con.prepareStatement("select consumed_holidayLeave from consumedleave where employeeId=?");
			ps.setString(1,employeeId );
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int holiday=res.getInt(1);
				total=holiday+askedDays;
			}
			 ps=con.prepareStatement("update consumedleave set consumed_holidayLeave=? where employeeId=?");
			 ps.setInt(1, total);
			 ps.setString(2, employeeId);
			 status = ps.executeUpdate();
			
		}
		if(leaveType.equals("Medical"))
		{
			PreparedStatement ps=con.prepareStatement("select consumed_medicalLeave from consumedleave where employeeId=?");
			ps.setString(1,employeeId );
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int planned=res.getInt(1);
				total=planned+askedDays;
			}
			 ps=con.prepareStatement("update consumedleave set consumed_medicalLeave=? where employeeId=?");
			 ps.setInt(1, total);
			 ps.setString(2, employeeId);
			 status = ps.executeUpdate();
		}

		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
		
	}
	
	public static int RejectEmployeeLeave(int slNo)
	{
		// TODO Auto-generated method stub
		int status = 0;
        con = DBConnection.getConnection();
        try {
			PreparedStatement ps = con.prepareStatement("update employeeleave set status='rejected' where slNo=? ");
			ps.setInt(1, slNo);
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
	
	
//	public static List<Integer> getNoOfDays(String slNo, String employeeId, String leaveType) 
//	{
//		List<Integer> list = new ArrayList<>();
//		// TODO Auto-generated method stub
//		 con = DBConnection.getConnection();
//		 try {
//			PreparedStatement ps = con.prepareStatement("select * from consumedleave where employeeId= ?");
//			ps.setString(1, employeeId);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next())
//			{
//				if(leaveType.equals("Planned"))
//				{
//					int typeOfDay = rs.getInt(2);
//					list.add(typeOfDay);
//				}
//				
//				if(leaveType.equals("Holiday"))
//				{
//					int typeOfDay = rs.getInt(3);
//					list.add(typeOfDay);
//				}
//				
//				if(leaveType.equals("Medical"))
//				{
//					int typeOfDay = rs.getInt(4);
//					list.add(typeOfDay);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;	
//	}
	
	
//	public static EmployeeLeave getSingleReq(int slNo)
//	{
//		EmployeeLeave empleave = new EmployeeLeave();
//		// TODO Auto-generated method stub
//		 con = DBConnection.getConnection();
//       try {
//		PreparedStatement ps = con.prepareStatement("select * from employeeleave where slNo=?");
//		ps.setInt(1, slNo);
//		 ResultSet rs = ps.executeQuery();
//		 while(rs.next())
//		 {
//			 empleave.setSlNo(rs.getInt(1));
//			 empleave.setEmployeeId(rs.getString(2));
//			 empleave.setName(rs.getString(3));
//			 empleave.setEmailId(rs.getString(4));
//			 empleave.setDept(rs.getString(5));
//			 empleave.setDateFrom(rs.getString(6));
//			 empleave.setDateto(rs.getString(7));
//			 empleave.setLeaveType(rs.getString(8));
//			 empleave.setDescp(rs.getString(9));
//			 empleave.setStatus(rs.getString(10));
//		 }
//		
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//       try {
//		con.close();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return empleave;		
//	}

	public static int updateTotalLeave(String employeeId, int askedDays, String leaveType)
	{
		int status = 0;
		// TODO Auto-generated method stub
		 con = DBConnection.getConnection();
		 if(leaveType.equals("Planned"))
		 {
				int planned1 = 0;
			 try {
				PreparedStatement ps = con.prepareStatement("select planned from employee where employeeId=?");
				ps.setString(1, employeeId);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					int planned = rs.getInt(1);
				      planned1 = planned-askedDays;
				}
			    PreparedStatement ps1 = con.prepareStatement("update employee set planned=? where employeeId=?");
			    ps1.setInt(1, planned1);
			    ps1.setString(2, employeeId);
			    status = ps1.executeUpdate();
			 	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		 
		 if(leaveType.equals("Holiday"))
		 {
			 int holiday1 = 0;
			 try {
				PreparedStatement ps = con.prepareStatement("select holiday from employee where employeeId=?");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					int holiday = rs.getInt(1);
					holiday1 = holiday-askedDays;
				}
				
				PreparedStatement ps1 = con.prepareStatement("update employee set holiday=? where employeeId=?");
				ps1.setInt(1, holiday1);
				ps1.setString(2, employeeId);
				status = ps1.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		 }
		 
		 if(leaveType.equals("Medical"))
		 {
			 int medical1 = 0;
			 try {
				PreparedStatement ps = con.prepareStatement("select medical from employee where employeeId=?");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
				  int medical = rs.getInt(1);	
				  medical1 = medical-askedDays;
				}
				PreparedStatement ps1 = con.prepareStatement("update employee set medical=? where employeeId=?");
				ps1.setInt(1, medical1);
				ps1.setString(2, employeeId);
				status = ps1.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		
		return status;
	}


	public static void myChanges(int total, int parseInt, String leaveType)
	{
		// TODO Auto-generated method stub
		if(leaveType.equals("Planned"))
		{
			// IN THS THE EMPLOYEELEAVE TABLE is altered by adding 3column called as:
           //planned,holiday,medical.
		   //	and hence query is written such that it will read(select) and update the particular leave-type by using slNo. 
		}
	}
	
}
