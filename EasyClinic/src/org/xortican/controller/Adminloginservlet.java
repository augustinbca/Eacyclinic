package org.xortican.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.DAO.Admindao;
import org.xortican.model.Adminpojo;
import org.xortican.util.JdbcCon;
@WebServlet("/Adminloginservlet")
public class Adminloginservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	 public Adminloginservlet() {
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
			
			
			
			String Adminname=request.getParameter("Adminname");
			String Password=request.getParameter("Password");
			System.out.println("wsedrftgyhujki");
			System.out.println("password values:"+Password);
			System.out.println("password values:"+Adminname);
			String forward = "";
			System.out.println("enter the servlet:");
			Admindao a;
			try {
				Connection con;
				con=JdbcCon.getconnection();
				PreparedStatement ps=con.prepareStatement("select * from adminlogin");
				ResultSet rs=ps.executeQuery();
				rs.next();
				
					
					if(Adminname.equalsIgnoreCase(rs.getString(1)) && Password.equalsIgnoreCase(rs.getString(2))) {
						forward = "AdminHome.jsp";
						
					}
					else  {
							
								forward = "Loginfailed.jsp";
							}
												
					RequestDispatcher rd=request.getRequestDispatcher(forward);
					rd.forward(request, response);
					}

				
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
				
			
		}


	


	}


