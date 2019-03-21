package org.xortican.util;

import java.sql.*;

public class JdbcCon
{
public static Connection con;
	
	public static Connection getconnection() throws SQLException, ClassNotFoundException 
	{
	if(con!=null)
	{
		return con;
	}
	else
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/medapp","root","root");  
	    return con;
	}
}
}
