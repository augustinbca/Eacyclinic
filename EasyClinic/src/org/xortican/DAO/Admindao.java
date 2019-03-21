package org.xortican.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import org.xortican.model.Adminpojo;
import org.xortican.util.JdbcCon;
import org.xortican.util.JdbcConnec;

public class Admindao {


	
		
	public Connection con;
		
		public Admindao() throws ClassNotFoundException, SQLException
		{
			con = JdbcCon.getconnection();
			System.out.println("Connection Success "+con);
		}

	public List<Adminpojo> checkCredentials() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		List<Adminpojo> list=new ArrayList<Adminpojo>();
		
		
		
		PreparedStatement ps= con.prepareStatement("select * from adminlogin");
		System.out.println(ps);
		Adminpojo ap=new Adminpojo();
		ResultSet rs=  ps.executeQuery();
		
		while (rs.next()){
			ap.setAdminname(rs.getString(1));
			ap.setPassword(rs.getString(2));
			
		}
		
		System.out.println("datas saved success " + list);
		list.add(ap);
		return null;
	}
	}

	
