package org.xortican.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.DAO.Createdocdao;
import org.xortican.model.Createdocpojo;
import org.xortican.util.JdbcConnec;

/**
 * Servlet implementation class DoctorUpdateServlet
 */
@WebServlet("/DoctorUpdateServlet")
public class DoctorUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorUpdateServlet() {
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
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobileno");
		String specialist=request.getParameter("specialist");
		String location=request.getParameter("location");
	/*	
		try {
			Createdocdao.update1(name,email,mobile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
Createdocpojo p=new Createdocpojo();
		
		p.setName(name);
		p.setEmail(email);
		p.setMobile(mobile);
		p.setSpecialist(specialist);
		p.setLocation(location);
		
		try {
			Createdocdao d=new Createdocdao();
			System.out.println("hello");
	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Insertsuccess.jsp");
			 dispatcher.forward(request, response);	
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
			rd.forward(request, response);
		}
	
	}

}
