<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<script type="text/javascript">
function validateEmail(emailField){
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

    if (reg.test(emailField.value) == false) 
    {
        alert('Invalid Email Address');
        return false;
    }

    return true;

}
	
	function isNumber(evt) {
		  evt = (evt) ? evt : window.event;
		  var charCode = (evt.which) ? evt.which : evt.keyCode;
		  if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		    alert("Please enter only Numbers.");
		    return false;
		  }

		  return true;
		}

		function ValidateNo() {
		  var phoneNo = document.getElementById('txtPhoneNo');

		  if (phoneNo.value == "" || phoneNo.value == null) {
		    alert("Please enter your Mobile No.");
		    return false;
		  }
		  if (phoneNo.value.length < 10 || phoneNo.value.length > 10) {
		    alert("Mobile No. is not valid, Please Enter 10 Digit Mobile No.");
		    return false;
		  }

		 
		  return true;
		}
	</script>
</script>
</head>
<body>
  <nav class="navbar navbar-inverse navbar-fixed-top" >
     <div class="container">
	  <div class="navbar-header">
	    <a class="navbar-brand" href="Home.jsp">HOME</a>
		 </div>
	  <ul class="nav navbar-nav navbar-right"> 
	    
		  <li><a href="UserLogin1.jsp">Exist User</a></li>
		  
		   </ul>
		    </div>
		     </nav>
		     
		     <div class="jumbotron text-center" style="height:500px; background-image:url('doctor.jpg');background-repeat:no-repeat;background-size:1500px 500px;">
	  
	  
	  <form name="MyForm" onSubmit="return ValidateEmail()" action="UserDet" method="post">
<center><h3>User Registration</h3></center>
<center><table>
<tr><td>User Name:</td>
<td><input type="text" name="name" placeholder="Name" required></td>
</tr><br>
<tr><td>Email Id:</td>
<td> <input type="text" name="mail" placeholder="abc@mail.com" onblur="validateEmail(this);"></td>
</tr><br>
<tr><td>Mobile No:</td>
<td><input id="txtPhoneNo" name="mobno" type="text" placeholder="Mobile No" onkeypress="return isNumber(event)" /></td>
</tr><br>
<tr><td><input type="submit" onclick="ValidateNo();" onclick="return ValidateEmail()" value="submit">
 </td></tr></ceter>

</form>



</table></center>




	  </div>
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
	 
         


</body>
</html>