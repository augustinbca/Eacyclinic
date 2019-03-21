<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



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
	    <a class="navbar-brand" href="Home.jsp">BACK</a>
		 </div></div></nav>
		 
		 
		 
		  <div class="jumbotron text-center" style="height:500px; background-image:url('doctor.jpg');background-repeat:no-repeat;background-size:1500px 500px;">
	  <h3 style ="margin-top:90px;">Doctor Details</h3>
          <form action="#" method="post">


 
   
         
         <center>         

         <table class="table table-bordered">
        <thead style="background-color:#7fa4e0;">
            <tr>
                <th>DR Name</th>
                <th>Email Id</th>
                <th>Mobile Number</th>
                <th>Specialist</th>
                <th>Location</th>
                <th colspan=1>Action</th>
            </tr>
        </thead>
        
  
  
  
                            
<% 
  try{
	  
	  
	  String name=request.getParameter("doctor");
	  String spec=request.getParameter("specialist");
	  String loca=request.getParameter("location");
	  Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/medapp","root","root"); 
		
		
       if(name!="" || spec!="" || loca!="")
       {
       String sql ="select * from doctordetails where name='"+name+"' ||specialist='"+spec+"' ||location='"+loca+"'";
         PreparedStatement ps=con.prepareStatement(sql);
		
		
         ResultSet rs;
         rs=ps.executeQuery();
        while(rs.next())
         {
         %>
         
        
        
        	
        
         
         		
         	<tbody style="background-color:#e8eaed;">	
         		<tr>
         		<td><%=rs.getString(1) %></td>
         		
         		<td><%=rs.getString(2) %></td>
         		
         		<td><%=rs.getString(3) %></td>
         		
         		<td><%=rs.getString(4) %></td>
         		         		
         		 <td><%=rs.getString(5) %></td>
         		 
         		<td> <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">BOOK</button>
</td>
         		 </tr>
                </tbody>
           <%  
         }
       }
       else
       {
    	   RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
       }
		  
        con.close();
  }
  catch (Exception e2)

    {

        e2.printStackTrace();
        RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
		rd.forward(request, response);

    }
  


 
  
  %>
  
  
  <a href="Home.jsp" class="btnback">BACK</a>         
</table>

    
</form>
  
  

         </center>


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
	
	 <div class="jumbotron text-center" style="background-color:black; margin-top:60px; height:100px;">
		   <p style="word-spacing:30px; color:white; margin-top:50px;"><i class="fa fa-wifi"></i>
		   <i class="fa fa-facebook"></i>
		   <i class="fa fa-twitter"></i>
		   <i class="fa fa-google-plus"></i>
		   <i class="fa fa-linkedin"></i></p>
		   <p style="font-size:14px; color:white;">©2018 Healthy World - All right reserved | Designed by <a hef="#" style="color:#00b300;">Xortian.</a></p>
		 </div>
		 
		 
		</center>
		
		 <div class="container-fluid">

<center>
<div class="container-fluid">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title" >Book Appointment</h3>
        </div>
        
        <div class="modal-body">
        
        
        <h3>If you new user just <a href="UserDetail.jsp">CLICK HERE</a></h3>
         <h3>If you Exiting user just <a href="UserLogin1.jsp">CLICK HERE</a></h3>
      
    

</div>
         <form action="home.jsp">
        <div class="modal-footer">
        
         
        </form>
        </div> 
        </div>
      </div>
      
    </div>
  </div>
  </div>
     

</body>
</html>