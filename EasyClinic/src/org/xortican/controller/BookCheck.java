package org.xortican.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class BookCheck
 */
@WebServlet("/BookCheck")
public class BookCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCheck() {
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
		 
			 String sql="";
			  
			  String da=request.getParameter("date");
			  String ti1=request.getParameter("name1");
			  String ma=request.getParameter("mail");
			  System.out.println(da+ti1+ma);
			  
			  try {
				Connection con1=JdbcCon.getconnection();
			
		        sql ="select * from booking";
		        PreparedStatement ps1=con1.prepareStatement(sql);
		         ResultSet rs1=ps1.executeQuery();
		         while(rs1.next())
		         {
			      if(ma!=rs1.getString(2))
			      {
			    	  RequestDispatcher rd=request.getRequestDispatcher("Bd3.jsp");
		    			rd.forward(request, response); 
			      }
			      else
			      {
			  try
			  {
			  Connection con=JdbcCon.getconnection();
		        sql ="select * from booking where mail='"+ma+"'";
		       System.out.println(sql);
		         PreparedStatement ps=con.prepareStatement(sql);
		         ResultSet rs=ps.executeQuery();
		        while(rs.next())
		         {
		        	String dmail=rs.getString(2);
		        	String date=rs.getString(4);
		        	String time=rs.getString(5);
		        	System.out.println(date+time);
		        	
		        	 if(da.equals(date)&&(ti1.equals(time)))
			        	{
			        		RequestDispatcher rd=request.getRequestDispatcher("Ab.jsp");
			    			rd.forward(request, response);
			        	}
		        	  
			        	else
			        	{
			        		RequestDispatcher rd=request.getRequestDispatcher("Bd3.jsp");
			    			rd.forward(request, response);
			        	}
		      
		            }

		 con.close();
		  }
		       
		  catch (Exception e2)

		    {
			  RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
				rd.forward(request, response);
		        e2.printStackTrace();

		    }
			      
		         
			      }
		  
		  
		         }
	}
			  catch(Exception e4)
			  {
				  RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
					rd.forward(request, response);
			  }

}
}
