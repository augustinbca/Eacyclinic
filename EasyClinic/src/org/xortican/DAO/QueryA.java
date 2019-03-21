package org.xortican.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.xortican.model.OtpGenerationPojo;
import org.xortican.model.UserDetPojo;
import org.xortican.util.JdbcCon;



public class QueryA {
public Connection con;

	
	public QueryA() throws ClassNotFoundException, SQLException
	{
		
		
		con=JdbcCon.getconnection();
	}
		public void insert(UserDetPojo ud)
		{
			try {
				PreparedStatement pst=con.prepareStatement
						("insert into userdetails values(?,?,?)");
				 pst.setString(1,ud.getName());  
			       pst.setString(2,ud.getMail());        
			       pst.setString(3,ud.getMobileno());
			       


			       int i = pst.executeUpdate();
				
				
			      
			       pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		
		
		
		
}
