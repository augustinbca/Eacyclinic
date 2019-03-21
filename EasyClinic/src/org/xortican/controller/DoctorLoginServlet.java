package org.xortican.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.xortican.DAO.DoctorLoginDAO;
import org.xortican.model.DoctorLoginPojo;

/**
 * Servlet implementation class DoctorLoginServlet
 */
@WebServlet("/DoctorLoginServlet")
public class DoctorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("enter the Servlet");
		String forward = "";
		DoctorLoginDAO loginDao;
		try {
			loginDao = new DoctorLoginDAO();
			List<DoctorLoginPojo> li=loginDao.checkCredentials();
			
			for(DoctorLoginPojo i: li) {
				System.out.println(i.getUsername());
				
				if(username.equalsIgnoreCase(i.getUsername()) && password.equalsIgnoreCase(i.getPassword())) {
					forward = "DoctorHome.jsp";
					break;
				}
				else if(username.equalsIgnoreCase(i.getUsername()) && password!=i.getPassword()){
					forward = "InvalidPass.jsp";
					break;
					
				}
				else if(username!=i.getUsername() && password.equalsIgnoreCase(i.getPassword())){
					forward = "InvalidUser.jsp";
					break;
				}
				
				else  {
						
							forward = "DoctorLoginFailed.jsp";
						}
											
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
			rd.forward(request, response);
		}
		
		
		
			RequestDispatcher rd=request.getRequestDispatcher(forward);
			rd.forward(request, response);
	
	}

}
