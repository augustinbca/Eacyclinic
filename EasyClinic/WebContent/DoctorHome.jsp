<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
<title>Doctor Home</title>
</head>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.xortican.util.JdbcCon" %>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" >
     <div class="container">
	  <div class="navbar-header">
	    <a class="navbar-brand" href="DoctorHome.jsp">Home</a>
		 </div>
	  <ul class="nav navbar-nav navbar-right"> 
	  <li><a href="NewFile3.jsp">Doctor Details</a></li>
	    <li><a href="DoctorEdit.jsp">EDIT</a></li>
	    <li><a href="DoctorAvailable.jsp">Upload available time</a></li>
		 <li><a href="ShowBookingDetails.jsp">View Booking</a></li>
		  <li><a href="ShowUserDetails.jsp">View user Details</a></li>
		   <li><a href="DoctorLogin.jsp">Logout</a></li>
		   </ul>
		    </div>
		     </nav>
	<div class="jumbotron text-center" style="height:500px; background-image:url('download.jpeg');background-repeat:no-repeat;background-size:1500px 500px;">
	     <% String mail=request.getParameter("username"); %>
	          <% 
  try{
	  
	  
	  
	  Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3307/easyclinic","root","root"); 
		
		
       if(mail!="")
       {
       String sql ="select * from doctordetails where email='"+mail+"'";
         PreparedStatement ps=con.prepareStatement(sql);
		
		
         ResultSet rs;
         rs=ps.executeQuery();
         rs.next();
         %>
        <br>
        <br>
        <br>
         <h2>WELCOME TO DR.<%=rs.getString(1)%></h2>
         
      <%
      }
       else if(mail=="0987")
       {
    	   RequestDispatcher rd=request.getRequestDispatcher("NewFile4.jsp");
			rd.forward(request, response);
			 RequestDispatcher rd1=request.getRequestDispatcher("editUser.jsp");
				rd1.forward(request, response);
       }
       
       else
       {
    	   RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
			rd.forward(request, response);
       }
		  
        
  }
  catch (Exception e2)
    {

        e2.printStackTrace();
        RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
		rd.forward(request, response);

    }
       %>
  
	    
	
        

    </div>
	 
	 <div class="jumbotron text-center" style="background-color:white;"">
	   <h2><b>ABOUT US</b></h2>
	   <p>We help practices improve the depth of their relationships with patients and improve
	   practice efficiency. Our core is in helping practices through tools like online appointments 
	   and SMART Recalls, but we’re always building new products and services.</p>
	 </div>
	 <div class="container">
	  <div class="row">
	    <div class="col-sm-4">
		 <img src="team1.jpg" class="img-responsive">
		</div>
		<div class="col-sm-4">
		<img src="team3.jpg" class="img-responsive">
		</div>
		
		<div class="col-sm-4">
		<img src="team4.jpg" class="img-responsive">
		</div>
	  </div>
	  <div class="row">
	  <div class="col-sm-4">
	     <div class="jumbotron text-center">
		  <p style="font-size:16px"><b>Good health starts with a happy heart</b></p>
		 </div>
	  </div>
	  <div class="col-sm-4">
	     <div class="jumbotron text-center">
		    <p style="font-size:14px"><b>May Every Day Find your feeling better!</b></p>
		  </div>
	  </div>
	  <div class="col-sm-4">
	      <div class="jumbotron text-center">
		    <p style="font-size:16px"><b>Drink a glass of water first….then see if you are hungry.</b></p>
		  </div>
	  </div>
	  
	  </div>
	   </div>
	
	 <div class="jumbotron text-center" style="background-color:black; margin-top:60px; height:270px;">
		   <p style="word-spacing:30px; color:white; margin-top:50px;"><i class="fa fa-wifi"></i>
		   <i class="fa fa-facebook"></i>
		   <i class="fa fa-twitter"></i>
		   <i class="fa fa-google-plus"></i>
		   <i class="fa fa-linkedin"></i></p>
		   <p style="font-size:14px; color:white;">©2018 Healthy World - All right reserved | Designed by <a hef="#" style="color:#00b300;">Xortian.</a></p>
		 </div>
	     
  
  



</body>
</html>