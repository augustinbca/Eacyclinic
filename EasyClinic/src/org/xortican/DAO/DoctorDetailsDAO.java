package org.xortican.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xortican.model.Createdocpojo;
import org.xortican.util.JdbcConnec;



public class DoctorDetailsDAO {

public static Connection con;
	
	public DoctorDetailsDAO() throws ClassNotFoundException, SQLException
	{
		 con = JdbcConnec.getConnection();
	}

	public List<Createdocpojo> getDetailsList() throws SQLException {

		List<Createdocpojo> doctorDetaillist = new ArrayList<>();
		PreparedStatement pst = con
				.prepareStatement("SELECT * FROM Doctordetails");
		System.out.println("AccountDetailsDAO | getDetailsList() | connection"
				+ con);
		System.out.println(pst);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Createdocpojo doctorDetails = new Createdocpojo();
			doctorDetails.setName(rs.getString(1));
			System.out.println("AccountDetailsDAO | getDetailsList() | in result set" + rs.getString("name"));
			doctorDetails.setEmail(rs.getString(2));
			doctorDetails.setMobile(rs.getString(3));
			doctorDetails.setSpecialist(rs.getString(4));
			doctorDetails.setLocation(rs.getString(5));
			doctorDetaillist.add(doctorDetails);

		}

		return doctorDetaillist;


}}
