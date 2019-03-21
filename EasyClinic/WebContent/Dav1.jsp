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
		     
		     <div class="jumbotron text-center" style="background-color:white;">
		     
		     
		     </div>
		     
		     <form action="DoctoravIns" method="post">
		     <center>
		     <div class="jumbotron text-center" style="background-color:white;">
	         
	          <form action="">
	          <%String mail=request.getParameter("mail"); %>
                                    <div class="form-group">
                                        <label>Email id</label>
                                        <input type="text" value="<%= mail %>" name="mail" id="mail">
                                        </div>
                                       <div class="form-group"> 
                                        <input type="submit" value="search" name="btn">
                                    </div>
                                    </form>
                                    
                                    <div class="form-group">
                                    <% 
  try{
	  String mail1=request.getParameter("mail");
	  Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3307/easyclinic","root","root"); 

       String sql ="select * from doctordetails where email='"+mail1+"'";
         PreparedStatement ps=con.prepareStatement(sql);
         ResultSet rs;
         rs=ps.executeQuery();
        while(rs.next())
         {
         
         	%>
         		
         		 <div class="jumbotron text-center" style="background-color:white;">
         		<div class="form-group">
         		<label>Name     </label>
         		<input type="text" name="name" value="<%=rs.getString(1) %>">
         		</div>
         		<div class="form-group">
         		<label>Email id </label>
         		<input type="text" name="mail" value="<%=rs.getString(2) %>">
         		</div>
         		<div class="form-group">
         		<label>Location </label>
         		<input type="text" name="loca" value="<%=rs.getString(5) %>">
         		</div>
         	
                
           <% 
            }
         %>
         <% con.close();
  }
       
  catch (Exception e2)

    { e2.printStackTrace();}
  %>
                                    
                                    
                                         
	        
                                    <div class="jumbotron text-center" style="background-color:white;">
		    
		     <div class="form-group">
         		<label>Date     </label>
         		<input type="date" name="date" >
         		</div>
         		
         		<div class="form-group">
         		<label>Slot 1     </label>
         		<input type="text" name="s1" value="">
         		</div>
         		
         		<div class="form-group">
         		<label>Slot 2     </label>
         		<input type="text" name="s2" value="">
         		</div>
         		
         		<div class="form-group">
         		<label>Slot 3     </label>
         		<input type="text" name="s3" value="">
         		</div>
         		
         		<div class="form-group">
         		<label>Slot 4     </label>
         		<input type="text" name="s4" value="">
         		</div>
         		
         		<div class="form-group">
         		<label>Slot 5     </label>
         		<input type="text" name="s5" value="">
         		</div>
		     
		     <input type="submit" name="upload" value="Upload">
		     
		     
		     </center>
		     
		     </div>
		           </div>	
		     	</div>
 </div>
 </form>
</body>
</html>