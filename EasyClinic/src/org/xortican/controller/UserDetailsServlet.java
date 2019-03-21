package org.xortican.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.xortican.DAO.UserDetailsDAO;
import org.xortican.model.UserDetailsPojo;

/**
 * Servlet implementation class UserDetailsServlet
 */
@WebServlet("/UserDetailsServlet")
public class UserDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		 String forward = "";
        String mail = request.getParameter("mail");
        
        try {
        	
			UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
			userDetailsDAO.getDetailsList();
			request.setAttribute("Accounts", userDetailsDAO.getDetailsList());
			 RequestDispatcher dispatcher = request.getRequestDispatcher("UserDetailsNew.jsp");
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
        UserDetailsPojo p=new UserDetailsPojo();
       
       
      
       
       
    	   
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
