package org.xortican.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xortican.model.BookingDetailsPojo;
import org.xortican.util.JdbcConnec;

public class ViewBookingDAO {
public static Connection con;
	
	public ViewBookingDAO() throws ClassNotFoundException, SQLException
	{
		 con = JdbcConnec.getConnection();
	}

	public List<BookingDetailsPojo> getDetailsList() throws SQLException {

		List<BookingDetailsPojo> bookingDetaillist = new ArrayList<>();
		PreparedStatement pst = con
				.prepareStatement("SELECT * FROM booking");
		System.out.println("AccountDetailsDAO | getDetailsList() | connection"
				+ con);
		System.out.println(pst);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			BookingDetailsPojo bookingDetails = new BookingDetailsPojo();
			bookingDetails.setname(rs.getString(1));
			System.out.println("AccountDetailsDAO | getDetailsList() | in result set" + rs.getString(1));
			bookingDetails.setemail(rs.getString(2));
			bookingDetails.setLocation(rs.getString(3));
			bookingDetails.setDate(rs.getString(4));
			bookingDetails.setTime(rs.getString(5));
			bookingDetails.setUname(rs.getString(6));
			bookingDetails.setUmail(rs.getString(7));
			bookingDetails.setUmob(rs.getString(8));
			bookingDetaillist.add(bookingDetails);

		}

		return bookingDetaillist;

	}
}
