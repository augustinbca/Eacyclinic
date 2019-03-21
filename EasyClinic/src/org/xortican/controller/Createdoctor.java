package org.xortican.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.DAO.Createdocdao;
import org.xortican.DAO.OtpPro;
import org.xortican.model.Createdocpojo;
import org.xortican.util.JdbcCon;




/**
 * Servlet implementation class Createdoctor
 */
@WebServlet("/Createdoctor")
public class Createdoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Createdoctor() {
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
		
		
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String specialist=request.getParameter("specialist");
		String location=request.getParameter("location");
		
		Createdocpojo p=new Createdocpojo();
		
		p.setName(name);
		p.setEmail(email);
		p.setMobile(mobile);
		p.setSpecialist(specialist);
		p.setLocation(location);
		
		try {
			Createdocdao d=new Createdocdao();
			d.insert(p);
			
			int randomPin   =(int)(Math.random()*9000)+100000;
			String otp  =String.valueOf(randomPin);
			System.out.println(otp);
			
			String to=email;
			
			String message="Welcome to EasyClinic Doctor your username :"+to+"Your Password"+otp;
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Insertsuccess.jsp");
			 dispatcher.forward(request, response);
			 
			 try {
					OtpPro.send(to, message, otp);
					
					try {
						Connection con=JdbcCon.getconnection();
						PreparedStatement pst=con.prepareStatement
								("insert into doctorlogin values(?,?)");
						 pst.setString(1,to);  
					       pst.setString(2,otp);
					       
					       int i=pst.executeUpdate();
					       
					       con.close();
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
						rd.forward(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
						rd.forward(request, response);
					}
			 }
			 catch(Exception e2)
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
					rd.forward(request, response);
		}
	
		} 
		catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
			rd.forward(request, response);
		}
			
		
		
	}

}
