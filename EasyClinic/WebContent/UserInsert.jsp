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
<title>patient detail form</title>
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

	 
	}

	function ValidateNo() {
	  var phoneNo = document.getElementById('txtPhoneNo');

	  if (phoneNo.value == "" || phoneNo.value == null) {
	    alert("Please enter your Mobile No.");
	    phoneNo.focus();
	    return false;
	  }
	  if (phoneNo.value.length < 10 || phoneNo.value.length > 10) {
	    alert("Mobile No. is not valid, Please Enter 10 Digit Mobile No.");
	    phoneNo.focus();
	    return false;
	  }

	  
	  
	}


</script>

</head>

<body>


		<nav class="navbar navbar-inverse navbar-fixed-top" >
     <div class="container">
	  <div class="navbar-header">
	    <a class="navbar-brand" href="Home.jsp">HOME</a>
		 </div>
	  <ul class="nav navbar-nav navbar-right"> 
	    
		 
		   <li><a href="UserHome.jsp">Back</a></li>
		   </ul>
		    </div>
		     </nav>
		     
		 <div class="jumbotron text-center" style="height:500px; background-image:url('doctor.jpg');background-repeat:no-repeat;background-size:1500px 500px;">
	       
		     <h3>Patient Details Form</h3>
	
		<form name="RegForm" onsubmit="ValidateNo();" onsubmit="return ValidateEmail()" action="UserIns" method="post" >
		<center>
			<table style="with: 50%">
			<tr>
					<td>Id</td>
					<td><input type="text" name="id" placeholder="Id" /></td>
				</tr>
			
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullname" placeholder="Name" required/></td>
				</tr>
				<tr>
					<td>Email id</td>
					<td><input type="text" name="mail" placeholder="abc@mail.com" onblur="validateEmail(this);"/></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" placeholder="Age" required/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="sex" placeholder="Gender" required/></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" placeholder="Address" required/></td>
				</tr>
				<tr>
					<td>Mobile No</td>
					<td><input id="txtPhoneNo" name="mobno" type="text" placeholder="Mobile No" onkeypress="return isNumber(event)" /></td>
				</tr>
				<tr>
					<td>Disease Describe</td>
					<td><input type="text" name="desc" placeholder="Disease describe" required/></td>
				</tr>
				<tr>
					<td>Previous treatment details</td>
					<td><input type="text" name="previous" placeholder="Previous Treatment Details" required/></td>
				</tr>
				<tr>
					<td>Dr Name</td>
					<td><input type="text" name="drname" placeholder="DR Name" required/></td>
				</tr>
			</table>
			</center>
			<input type="submit"  value="register" />
		</form>
		<br>
		
		
		

</body>
</html>