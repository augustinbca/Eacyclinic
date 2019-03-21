<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="images/favicon.png">
<title>Account Details</title>
<!-- Bootstrap Core CSS -->
<link href="css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/helper.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:** -->
<!--[if lt IE 9]>
    <script src="https:**oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https:**oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<style>
body {
	font-family: "Lato", sans-serif;
}

#sidebar {
	height: 100vh;
	width: 200px;
	position: fixed;
	z-index: 995;
	top: 50;
	left: 0;
	background-color: #5c85d6;
	overflow-x: hidden;
	padding-top: 22px;
}

#sidebar a {
	padding: 16px 18px 16px 16px;
	text-decoration: none;
	font-size: 40px;
	color: #818181;
	display: block;
}

#sidebar a:hover {
	color: #f1f1f1;
}

.main {
	margin-left: 100px; /* Same as the width of the sidenav */
	font-size: 28px; /* Increased text to enable scrolling */
	padding: 05px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>


<body style="width: 100%;">
	<!-- for sidebar -->
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-2">
				<div class="wrapper">
					<nav id="sidebar">
						<div class="sidebar-header">
							<span class="alert alert-info"><t></span>
						</div>

						<a href="AdminMainpage.jsp"><button type="button"
								class="btn btn-success btn-block">Admin Home</button></a> <a
							href="UserIndex.jsp">
							<button type="button" class="btn btn-success btn-block">
								User Details</button>
						</a> <a href="AccountIndex.jsp">
							<button type="button" class="btn btn-success btn-block">Account
								Details</button>
						</a> <a href="AdminLogin.jsp"><button type="button"
								class="btn btn-success btn-block">SignOut/LogOut</button></a>
					</nav>
				</div>
			</div>

			<!-- end of sidebar -->
			<!-- for creating header -->
			<div class="container-fluid">
				<div class="row">
					<header class="header">
						<img src="FinancialManagement.jpg"
							style="height: 150px; width: 1500px; margin-right: 0px; margin-left: 170px">
					</header>
				</div>
			</div>
			<!-- end of header -->

			<div class="container-fluid"
				style="align: center; height: 100px; width: 50%;">
				<div class="row">
					<div class="col-md-12" align="center">


						<div class="container">
							
								<table border=1 class="table">
									<thead>
										<tr>
											<th>Name</th>
											<th>Email</th>
											<th>Mobile</th>
											<th>Specialist</th>
											<th>Location</th>
											<th colspan=1>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${Accounts}" var="account">
											<tr>
												<td><c:out value="${account.name}" /></td>
												<td><c:out value="${account.email}" /></td>
												<td><c:out value="${account.mobile}" /></td>
												<td><c:out value="${account.specialist}" /></td>
												<td><c:out value="${account.location}" /></td>
												
												<td><a
													href="AccountDetailsServlet?action=statement&userName=<c:out value="${account.userName}"/>">Statement</a></td>
													
											</tr>
										</c:forEach>
									</tbody>
								</table>



							

						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- End Wrapper -->
		<!-- All Jquery -->
		<script src="js/lib/jquery/jquery.min.js"></script>
		<!-- Bootstrap tether Core JavaScript -->
		<script src="js/lib/bootstrap/js/popper.min.js"></script>
		<script src="js/lib/bootstrap/js/bootstrap.min.js"></script>
		<!-- slimscrollbar scrollbar JavaScript -->
		<script src="js/jquery.slimscroll.js"></script>
		<!--Menu sidebar -->
		<script src="js/sidebarmenu.js"></script>
		<!--stickey kit -->
		<script src="js/lib/sticky-kit-master/dist/sticky-

kit.min.js"></script>
		<!--Custom JavaScript -->
		<script src="js/custom.min.js"></script>



	</div>
</body>
</html>