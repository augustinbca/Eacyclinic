package org.xortican.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.xortican.model.Createdocpojo;
import org.xortican.util.JdbcConnec;




public class Createdocdao {
	
public static Connection con;
	
	public Createdocdao() throws ClassNotFoundException, SQLException
	{
		con = JdbcConnec.getConnection();
	}
	
	 public void insert (Createdocpojo po) throws SQLException {
		
		PreparedStatement ps=con.prepareStatement("Insert into Doctordetails values(?,?,?,?,?)");
		
		
		ps.setString(1,po.getName());
		ps.setString(2,po.getEmail());
		ps.setString(3,po.getMobile());
		ps.setString(4, po.getSpecialist());
		ps.setString(5, po.getLocation());
		
		int i = ps.executeUpdate();	
	}
	
}
