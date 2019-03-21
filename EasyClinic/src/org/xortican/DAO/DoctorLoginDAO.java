package org.xortican.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xortican.model.DoctorLoginPojo;
import org.xortican.util.JdbcConnec;



public class DoctorLoginDAO {
	public Connection con;
	  public DoctorLoginDAO() throws ClassNotFoundException, SQLException
	  {
	 con=JdbcConnec.getConnection();
	  }
	  public List<DoctorLoginPojo> checkCredentials() throws SQLException {
			// TODO Auto-generated method stub
			List<DoctorLoginPojo> list=new ArrayList<>();
			
			System.out.println("datas saved success " + list);
			
			PreparedStatement ps= con.prepareStatement("select * from doctorlogin");
			System.out.println(ps);
			
			ResultSet rs= ps.executeQuery();
			DoctorLoginPojo ap=new DoctorLoginPojo();
			while (rs.next()){
				System.out.println(rs.getString("username"));
				
				
				ap.setUsername(rs.getString("username"));
				ap.setPassword(rs.getString("password"));
				
				
			}
			list.add(ap);
			return list;
			
			
			

	  }
}
