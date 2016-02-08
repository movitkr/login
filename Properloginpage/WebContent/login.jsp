<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<%@include file="header.jsp" %>
<%@include file="footer.jsp" %>
</head>
<body>
<p><center><h3>Login</h3></center><br><br>
<form action="Loginserv" method="post"><center> 
Name:<input type="text" name="name"><br>  
Password:<input type="password" name="password"><br>  
<input type="submit" value="LOGIN">  </center> 
</form>
</body>
</html>