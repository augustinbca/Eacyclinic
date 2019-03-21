<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form method="post" action="Otpservlet">
  <table>
  <tr>
    <td>To</td>
   <td> <input type="text" name="to"></td>
   </tr>
    <tr>
    <td>Subject</td>
   <td> <input type="text" name="subject"></td>
   </tr>
    <tr>
    <td>Message</td>
   <td> <input type="text" name="message"></td>
   </tr>
   <tr><td>
   <input type="submit" value="send"></td>
   </tr>
  </table>
  </form>

</body>
</html>