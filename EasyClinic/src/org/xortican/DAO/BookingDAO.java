package org.xortican.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xortican.model.BookingPojo;
import org.xortican.model.DocSeaPojo;
import org.xortican.util.JdbcCon;
import org.xortican.util.JdbcConnec;

public class BookingDAO {
public static Connection con;

	
	public BookingDAO() throws ClassNotFoundException, SQLException
	{
		 con = JdbcCon.getconnection();
		 
	}

	public List<BookingPojo> getDetailsList() throws SQLException {

		List<BookingPojo> doctorDetaillist = new ArrayList<>();
		
		DocSeaPojo d=new DocSeaPojo();
		String name=d.getName();
		String loca=d.getLoca();
		String spec=d.getSpec();
		
		System.out.println(name+loca+spec);
		PreparedStatement pst = con
				.prepareStatement("SELECT * FROM doctoravail where name='"+name+"' ||specialist='"+spec+"' ||location='"+loca+"'");
		System.out.println("AccountDetailsDAO | getDetailsList() | connection"
				+ con);
		System.out.println(pst);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			BookingPojo doctorDetails = new BookingPojo();
			doctorDetails.setName(rs.getString("name"));
			System.out.println("AccountDetailsDAO | getDetailsList() | in result set" + rs.getString("name"));
			doctorDetails.setEmail(rs.getString("email"));
			doctorDetails.setMobile(rs.getString("mobile"));
			doctorDetails.setSpecialist(rs.getString("specialist"));
			doctorDetails.setLocation(rs.getString("location"));
			doctorDetails.setDate(rs.getString("date"));
			doctorDetails.setTime(rs.getString("time"));
			
			doctorDetaillist.add(doctorDetails);

		}

		return doctorDetaillist;

	}

}
