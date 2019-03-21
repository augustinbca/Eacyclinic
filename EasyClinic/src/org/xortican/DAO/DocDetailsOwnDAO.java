package org.xortican.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xortican.model.Createdocpojo;
import org.xortican.util.JdbcConnec;




public class DocDetailsOwnDAO {
	public Connection connection;

	public DocDetailsOwnDAO() throws ClassNotFoundException, SQLException {
		connection = JdbcConnec.getConnection();
		System.out.println( connection);
	}

	public List<Createdocpojo> getDocdetails(String email) throws SQLException {
    System.out.println("The name is "+ email);
		List<Createdocpojo> docDetailList = new ArrayList<>();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM doctordetails WHERE email = '" + email +"'");
		System.out.println( connection);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(pst + rs.getString("email") + rs.getString("name"));

			Createdocpojo docDetails = new Createdocpojo();
			docDetails.setName(rs.getString(1));
			docDetails.setEmail(rs.getString(2));
			docDetails.setMobile(rs.getString(3));
			docDetails.setSpecialist(rs.getString(4));
			docDetails.setLocation(rs.getString(5));
			docDetailList.add(docDetails);
		}
       System.out.println("the doctor detail is");
		return docDetailList;


	}
}
