package org.xortican.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.util.JdbcCon;


/**
 * Servlet implementation class deleteBook
 */
@WebServlet("/deleteBook")
public class deleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteBook() {
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
		      
		 try{
			  
			  
			  String b=request.getParameter("umail");
			  String c=request.getParameter("date");
			  String d=request.getParameter("time");
				Connection con=JdbcCon.getconnection();

		       String sql ="delete from booking where umail='"+b+"'&& date='"+c+"'&& time='"+d+"'";
		         PreparedStatement ps=con.prepareStatement(sql);
		         int rs;
		         rs=ps.executeUpdate(sql);
		         
		         RequestDispatcher rd=request.getRequestDispatcher("eB2.jsp");
					rd.forward(request, response);
		         

	      con.close();
		  }
		       
		  catch (Exception e2)

		    {
			  RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);

		        System.out.println(e2);

		    }


	}

}
