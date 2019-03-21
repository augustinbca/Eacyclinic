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
 * Servlet implementation class DoctoravIns
 */
@WebServlet("/DoctoravIns")
public class DoctoravIns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctoravIns() {
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
		
		String a=request.getParameter("name");
		String b=request.getParameter("mail");
		String c=request.getParameter("loca");
		String d=request.getParameter("date");
		String e=request.getParameter("s1");
		String f=request.getParameter("s2");
		String g=request.getParameter("s3");
		String h=request.getParameter("s4");
		String i=request.getParameter("s5");
		
		Connection con;
		
		try {
			con=JdbcCon.getconnection();
			PreparedStatement ps=con.prepareStatement("insert into doctorav values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			ps.setString(5, e);
			ps.setString(6, f);
			ps.setString(7, g);
			ps.setString(8, h);
			ps.setString(9, i);
			
		    int j=ps.executeUpdate();
		    
		    RequestDispatcher rd=request.getRequestDispatcher("Dav2.jsp");
			rd.forward(request, response);
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		
	}

}
