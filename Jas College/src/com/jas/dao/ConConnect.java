package com.jas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConConnect {
	private static Connection con=null;
	public static Connection getConnect () throws SQLException
	{
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
		return con;
		
	}
}
