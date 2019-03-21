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
 * Servlet implementation class UserIns
 */
@WebServlet("/UserIns")
public class UserIns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIns() {
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
		
		
         String name = request.getParameter("fullname");  
         String email = request.getParameter("mail");  
         String age = request.getParameter("age");  
         String sex = request.getParameter("sex");  
         String address = request.getParameter("address"); 
         String mobno = request.getParameter("mobno");
         String dises = request.getParameter("desc");  
         String previous  = request.getParameter("previous");  
         String drname = request.getParameter("drname");
         
         try {
        	 
        	 Connection con;
		
				con = JdbcCon.getconnection();
			
				PreparedStatement pst=con.prepareStatement
						("insert into UserInsert values(?,?,?,?,?,?,?,?,?)");
				   
			       pst.setString(1,name);        
			       pst.setString(2,email);
			       pst.setString(3,age);  
			       pst.setString(4,sex);        
			       pst.setString(5,address);
			       pst.setString(6,mobno);  
			       pst.setString(7,dises);        
			       pst.setString(8,previous);
			       pst.setString(9,drname);  
			               
			       


			       int i = pst.executeUpdate();
			      
			       RequestDispatcher dispatcher = request.getRequestDispatcher("UserHome.jsp");
					 dispatcher.forward(request, response);
				
			      
			       
			}
         catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
				rd.forward(request, response);
			}
         
         catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
				rd.forward(request, response);
			}
        
	}
}


