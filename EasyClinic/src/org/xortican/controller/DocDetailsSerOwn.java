package org.xortican.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.DAO.DocDetailsOwnDAO;
import org.xortican.DAO.DoctorDetailsDAO;

/**
 * Servlet implementation class DocDetailsSerOwn
 */
@WebServlet("/DocDetailsSerOwn")
public class DocDetailsSerOwn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocDetailsSerOwn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String forward = "";
         String email = request.getParameter("email");
         try {
			DocDetailsOwnDAO doctorDetailsDAO = new DocDetailsOwnDAO();
			request.setAttribute("Accounts", doctorDetailsDAO.getDocdetails(email));
			 RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorDetailsDoc.jsp");
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
         
        
       
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
