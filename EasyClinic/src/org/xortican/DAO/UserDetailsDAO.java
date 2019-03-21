package org.xortican.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xortican.controller.UserDetailsServlet;
import org.xortican.model.Createdocpojo;
import org.xortican.model.UserDetailsPojo;
import org.xortican.util.JdbcCon;
import org.xortican.util.JdbcConnec;

public class UserDetailsDAO {
	public static Connection con;

	public UserDetailsDAO() throws ClassNotFoundException, SQLException
	{
		 con = JdbcCon.getconnection();
	}

	public List<UserDetailsPojo> getDetailsList() throws SQLException {
        UserDetailsServlet ud;
       
		List<UserDetailsPojo> userDetaillist = new ArrayList<>();
		PreparedStatement pst = con
				.prepareStatement("SELECT * FROM userinsert");
		System.out.println("AccountDetailsDAO | getDetailsList() | connection"
				+ con);
		System.out.println(pst);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			UserDetailsPojo userDetails = new UserDetailsPojo();
		
			userDetails.setName(rs.getString(1));
			System.out.println("AccountDetailsDAO | getDetailsList() | in result set" + rs.getString(1));
			userDetails.setEmail(rs.getString(2));
			userDetails.setAge(rs.getString(3));
			userDetails.setSex(rs.getString(4));
			userDetails.setAddress(rs.getString(5));
			userDetails.setMobileno(rs.getString(6));
			userDetails.setDises(rs.getString(7));
			userDetails.setPrevious(rs.getString(8));
			userDetails.setDrname(rs.getString(9));
			userDetaillist.add(userDetails);

		}

		return userDetaillist;


	}
}
