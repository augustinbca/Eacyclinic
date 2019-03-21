package org.xortican.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.DAO.OtpPro;
import org.xortican.DAO.QueryA;
import org.xortican.util.JdbcCon;

/**
 * Servlet implementation class OtpGen
 */
@WebServlet("/OtpGen")
public class OtpGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtpGen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int randomPin   =(int)(Math.random()*9000)+100000;
		String otp  =String.valueOf(randomPin);
		System.out.println(otp);
		
		String to =request.getParameter("mail");
	
		String message ="hi";
		
		System.out.println(to+message);
		
		try {
			OtpPro.send(to, message, otp);
			
			try {
				Connection con=JdbcCon.getconnection();
				PreparedStatement pst=con.prepareStatement
						("insert into Userotp values(?,?)");
				 pst.setString(1,to);  
			       pst.setString(2,otp);
			       
			       int i=pst.executeUpdate();
			       
			       con.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher rd=request.getRequestDispatcher("Error1.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher rd=request.getRequestDispatcher("Error1.jsp");
				rd.forward(request, response);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserOtp.jsp");
			 dispatcher.forward(request, response);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
