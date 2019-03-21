package org.xortican.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.util.BookingUtil;

import org.xortican.util.JdbcConnec;

/**
 * Servlet implementation class BookingConfirmServlet
 */
@WebServlet("/BookingConfirmServlet")
public class BookingConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingConfirmServlet() {
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
		String to =request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String drname=request.getParameter("drname");
		String drmail=request.getParameter("drmail");
	
		
		try {
			BookingUtil.sent(to,date,time);
			try {
				Connection con =JdbcConnec.getConnection();
				PreparedStatement pst = con.prepareStatement("insert into  bookingdetails values(?,?,?,?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, to);
				pst.setString(3, mobile);
				pst.setString(4, date);
				pst.setString(5, time);
				pst.setString(6, drname);
				pst.setString(7, drmail);
				int i=pst.executeUpdate();
				RequestDispatcher dispatcher = request.getRequestDispatcher("BookingConfirm.jsp");
				 dispatcher.forward(request, response);	
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
				rd.forward(request, response);
			}
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
			rd.forward(request, response);
		}
		  

	}

}
