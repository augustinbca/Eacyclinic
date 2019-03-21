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
 * Servlet implementation class existUserLogin
 */
@WebServlet("/existUserLogin")
public class existUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public existUserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String mail=request.getParameter("mail");
		String otp=request.getParameter("otp");
		System.out.println(mail + otp);
try {
			
			Connection con=JdbcCon.getconnection();
			PreparedStatement pst=con.prepareStatement("select * from Userotp where mail='"+mail +"'");
			ResultSet rs=pst.executeQuery();
			rs.next();
			String m=rs.getString(1);
			String o=rs.getString(2);
			System.out.println(rs.getString(1)+rs.getString(2));
			
				if(mail.equals(m) && otp.equals(o))
				{
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("UserHome.jsp");
					 dispatcher.forward(request, response);
				}
				else
				{
					System.out.println("error");
				}			
}	
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
			rd.forward(request, response);
		}


		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
