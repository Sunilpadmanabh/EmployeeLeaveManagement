package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection
{
	static String url = "jdbc:mysql://localhost:3306/signiwis";
	static String usr = "root";
	static String pwd = "root";
	static Connection con;
	
	public static Connection getConnection()
	{
		try {
			System.out.println("connecting...");
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, usr, pwd);
				System.out.println("connected.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
