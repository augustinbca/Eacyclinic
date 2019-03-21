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
<title>Insert title here</title>
</head>

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
		     
		      <div class="jumbotron text-center" style="background-color:white;">
		     
		     
		     </div>
		     
		     
		     
		     <div class="jumbotron text-center" style="background-color:white;">
	         
	          <form action="Dav1.jsp">
                                    <div class="form-group">
                                        <label>Email id</label>
                                        <input type="text" placeholder="abc@mail.com" name="mail" id="mail">
                                        <input type="submit" value="search" name="btn">
                                    </div>
                                    	           
	         </div>


</body>
</html>