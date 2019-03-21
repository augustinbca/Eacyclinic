package org.xortican.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xortican.DAO.QueryA;
import org.xortican.model.UserDetPojo;


/**
 * Servlet implementation class UserDet
 */
@WebServlet("/UserDet")
public class UserDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDet() {
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
		 response.setContentType("text/html");  
         PrintWriter pw = response.getWriter(); 
         //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
         //Connection connection;
         
         UserDetPojo ud = new UserDetPojo();
     	
         String name = request.getParameter("name");  
         String mail = request.getParameter("mail");  
         String mobileno = request.getParameter("mobno");  
         
         
         System.out.println(name+mail);
         
         
     try{ 
    	 
       
       ud.setName(name);
       ud.setMail(mail);
       ud.setMobileno(mobileno);
      
       
       QueryA q=new QueryA();
       q.insert(ud);
       
       
       
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserLogin.jsp");
		 dispatcher.forward(request, response);

     }
       catch(Exception e)
	     {
	    	
	    	 RequestDispatcher dispatcher = request.getRequestDispatcher("DataError.jsp");
			 dispatcher.forward(request, response);
			 pw.println(e);
	     }
    

         }
       
      
     
    
	}

	


