package org.xortican.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.util.BookingUtil;
import org.xortican.util.JdbcCon;

/**
 * Servlet implementation class BookIns
 */
@WebServlet("/BookIns")
public class BookIns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookIns() {
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
		
		String drname=request.getParameter("name");
		String drmail=request.getParameter("mail");
		String drloca=request.getParameter("loca");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String pname=request.getParameter("pname");
		String to=request.getParameter("pmail");
		String mob=request.getParameter("mobno");
		
		try
		{
			BookingUtil.sent(to,date,time);
			try
			{
			Connection con;
			con=JdbcCon.getconnection();
			PreparedStatement ps=con.prepareStatement("insert into booking values(?,?,?,?,?,?,?,?)");
			ps.setString(1, drname);
			ps.setString(2, drmail);
			ps.setString(3, drloca);
			ps.setString(4, date);
			ps.setString(5, time);
			ps.setString(6, pname);
			ps.setString(7, to);
			ps.setString(8, mob);
			int i=ps.executeUpdate();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("BookingConfirm.jsp");
			 dispatcher.forward(request, response);	
			
		}
		catch(Exception e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
			rd.forward(request, response);
		}
		
		}
	catch(Exception e1)
			{
		RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
		rd.forward(request, response);          
			}
	}

}
