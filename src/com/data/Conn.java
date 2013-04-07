package com.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	static String url = "jdbc:mysql://localhost:3306/examsuite";
	static String uname = "root";
	static String password = "root";
	static Connection con;
	public static Connection getConnection()
	{
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,uname,password);
				return con;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

}
