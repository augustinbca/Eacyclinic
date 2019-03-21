package org.xortican.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdaPro
 */
@WebServlet("/UpdaPro")
public class UpdaPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdaPro() {
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
		
		String a=request.getParameter("id");
		String b=request.getParameter("name");
		String c=request.getParameter("mail");
		String d=request.getParameter("age");
		String e=request.getParameter("sex");
		String f=request.getParameter("add");
		String g=request.getParameter("mob");
		String h=request.getParameter("dis");
		String i=request.getParameter("pre");
		String j=request.getParameter("dr");

		if(a!=null&&b!=null&&c!=null&&d!=null&&e!=null&&f!=null&&g!=null&&h!=null&&i!=null&&j!=null)
		{
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/medapp","root","root"); 
			String sql="update userinsert set id=?,name=?,email=?,age=?,sex=?,address=?,mobileno=?,dises=?,previous=?,drname=? where id='"+a+"'";
			 PreparedStatement ps=con.prepareStatement(sql);
			 
			 ps.setString(1,a);
			 ps.setString(2,b);
			 ps.setString(3,c);
			 ps.setString(4,d);
			 ps.setString(5,e);
			 ps.setString(6,f);
			 ps.setString(7,g);
			 ps.setString(8,h);
			 ps.setString(9,i);
			 ps.setString(10,j);
		  
		   int m= ps.executeUpdate();
		    
		   RequestDispatcher dispatcher = request.getRequestDispatcher("UserHome.jsp");
			 dispatcher.forward(request, response);

			}
			 catch (Exception e1)

		    {

		        e1.printStackTrace();
		        RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
				rd.forward(request, response);

		    }
		}


		
	}

}
