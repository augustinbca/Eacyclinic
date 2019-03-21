<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="javax.servlet.http.*"%>
    
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	    <a class="navbar-brand" href="Home.jsp">Home</a>
		 </div>
	  <ul class="nav navbar-nav navbar-right"> 
	    
		 <li><a href="UserHome.jsp">User Home</a></li>
		  
		   <li><a href="UserOtp.jsp">Logout</a></li>
		   </ul>
		    </div>
		     </nav>
		     
		     
	<div class="jumbotron text-center" >
	
	<form action="BookIns" method="post">
                                  <%String a=request.getParameter("mail"); %>     
                                       
                                        <h2>Book your Appointment</h2>	
		
		<center>
		 <table>
		 <tr>
		 <th>Dr Email-Id: </th>
		 <td><input name="mail" value="<%=a %>"></td>
		 </tr>
		 <tr>
		 	 </table>
		 </center>
		 					
	<%String b=request.getParameter("mail1");
	  String c=request.getParameter("name2");
	  String d=request.getParameter("loca");
	  String f=request.getParameter("date");
	   %>
                	
         	    <div class="jumbotron text-center" style="background-color:white;">
         		<div class="form-group">
         		<label>Doctor Name</label>
         		<input name="name" value="<%=c %>">
         		</div>
         		
         		<div class="form-group">
         		<label>Location </label>
         		<input name="loca" value="<%=d %>">
         		</div>
         		
         		
         		<div class="form-group">
         		<label>Date </label>
         		<input name="date" value="<%=f %>">
         		</div>
         		<% String ti=request.getParameter("name1");%>
         		<div class="form-group">
         		<label>Time </label>
         		<input name="time" value="<%=ti %>">
         		</div>
         		
         		<div class="form-group">
         		<label>Patient Name</label>
         		<input type="text" name="pname" placeholder="Patient name">
         		</div>
         		
         		<div class="form-group">
         		<label>Patient Email </label>
         		<input type="text" name="pmail" placeholder="abc@mail.com">
         		</div>
         		
         		
         		<div class="form-group">
         		<label>Mobile No </label>
         		<input type="text" name="mobno" placeholder="mobile number">
         		</div>
         		
         		<div class="form-group">
         		
         		<input type="submit"  value="Book">
         		</div>
         		</div>
         		</form>
         		
         		
         		
         		
         
   
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