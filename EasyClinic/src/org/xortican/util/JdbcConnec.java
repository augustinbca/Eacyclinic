package org.xortican.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnec {
	public static Connection conn;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
if(conn!=null) {
return conn;
}
else {
Class.forName("com.mysql.jdbc.Driver"); 
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medapp","root","root");
return conn;
}
	}
}
