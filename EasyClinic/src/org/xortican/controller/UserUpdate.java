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

import org.xortican.util.JdbcCon;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
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
		
		 Connection con;
			
			try {
				String email = request.getParameter("mail"); 
				con = JdbcCon.getconnection();
				PreparedStatement pst=con
						.prepareStatement("select * from userinsert where email='"+email+"'");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					 String id =rs.getString(1);  
			         String name = rs.getString(2);  
			         String mail = rs.getString(3);
			         String age = rs.getString(4); 
			         String sex = rs.getString(5);
			         String address = rs.getString(6);
			         String mobno = rs.getString(7);
			         String dises = rs.getString(8); 
			         String previous  = rs.getString(9);  
			         String drname = rs.getString(10);
			         
			         request.setAttribute("Accounts", id);
			         request.setAttribute("Accounts", name);
			         request.setAttribute("Accounts", email);
			         request.setAttribute("Accounts", age);
			         request.setAttribute("Accounts", sex);
			         request.setAttribute("Accounts", address);
			         request.setAttribute("Accounts", mobno);
			         request.setAttribute("Accounts", dises);
			         request.setAttribute("Accounts", previous);
			         request.setAttribute("Accounts", drname);
			         
			         RequestDispatcher dispatcher = request.getRequestDispatcher("UserDetailsNew.jsp");
				       dispatcher.forward(request, response);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
				rd.forward(request, response);
			}
		
			
			
		
		

	}

}
