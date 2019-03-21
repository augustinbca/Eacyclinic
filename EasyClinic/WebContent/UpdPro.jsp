<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Process</title>
</head>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.xortican.util.JdbcCon" %>

<body>
<%
String a=request.getParameter("id");
String b=request.getParameter("name");
String c=request.getParameter("mail");
String d=request.getParameter("age");
String e=request.getParameter("sex");
String f=request.getParameter("add");
String g=request.getParameter("mob");
String h=request.getParameter("dis");
String i=request.getParameter("pre");
String j=request.getParameter("dr");

if(a!=null&&b!=null&&c!=null&&d!=null&&e!=null&&f!=null&&g!=null&&h!=null&&i!=null&&j!=null)
{
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/medapp","root","root"); 
	String sql="update userinsert set id=?,name=?,email=?,age=?,sex=?,address=?,mobileno=?,dises=?,previous=?,drname=? where='"+a+"'";
	 PreparedStatement ps=con.prepareStatement(sql);
	 
	 ps.setString(1,a);
	 ps.setString(2,b);
	 ps.setString(3,c);
	 ps.setString(4,d);
	 ps.setString(5,e);
	 ps.setString(6,f);
	 ps.setString(7,g);
	 ps.setString(8,h);
	 ps.setString(9,i);
	 ps.setString(10,j);
  
   int m= ps.executeUpdate();
    
    response.sendRedirect("UserHome.jsp");
	}
	 catch (Exception e1)

    {

        e1.printStackTrace();
        RequestDispatcher rd=request.getRequestDispatcher("DataError.jsp");
		rd.forward(request, response);

    }
}

%>



</body>
</html>