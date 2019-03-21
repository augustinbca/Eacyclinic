package org.xortican.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.xortican.util.JdbcCon;

/**
 * Servlet implementation class otpGen1
 */
@WebServlet("/otpGen1")
public class otpGen1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public otpGen1() {
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
		
		
		
		doGet(request, response);
		int randomPin   =(int)(Math.random()*9000)+100000;
		String otp  =String.valueOf(randomPin);
		System.out.println(otp);
		
		String to =request.getParameter("mail");
	
		String message ="hi";
		
		System.out.println(to+message);
		
		PrintWriter p = response.getWriter();
        try
        {
     	  
     	   Connection con;
     	   con=JdbcCon.getconnection();
     	   PreparedStatement ps=con.prepareStatement("select * from userotp");
     	   ResultSet rs;
     	   rs=ps.executeQuery();
     	   while(rs.next())
     	   {
     		   
     		   if(to.equalsIgnoreCase(rs.getString(1)))
     		   {
		
		try {
			OtpPro.send(to, message, otp);
			
			try {
				Connection con1=JdbcCon.getconnection();
				PreparedStatement pst1=con.prepareStatement
						("select * from userotp");
				ResultSet rs1;
				rs1=pst1.executeQuery();
				while(rs1.next())
				{
					rs.getString(1);	
				
				if(to.equals(rs.getString(1)))
				{
					try
					{
						Connection con2=JdbcCon.getconnection();
						PreparedStatement pst2=con.prepareStatement
								("update userotp set otp='"+otp+"' where mail='"+to+"'");
						
						int s=pst2.executeUpdate();
					}
					catch(Exception e)
					{
						
						e.printStackTrace();
						RequestDispatcher dispatcher = request.getRequestDispatcher("otpError.jsp");
						 dispatcher.forward(request, response);
						
					}
				}
				}
			       con.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserOtp.jsp");
			 dispatcher.forward(request, response);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("otpError.jsp");
			 dispatcher.forward(request, response);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("otpError.jsp");
			 dispatcher.forward(request, response);
		}
     		  }
     		   else
     		   {
     			  RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
     			 dispatcher.forward(request, response);
     		   }
     	   }
        }
        catch(Exception e)
        {
     	   
        }


	}

}
