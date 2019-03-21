<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.servlet.http.*"%>
    
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Details</title>
</head>
<body>
   							
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
												
													
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
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
   
</body>
</html>