<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>signup</title>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>
</head>
<body>
<p><center><h3>Sign_up</h3>
<form action="Signupserv" method="post">  
Name:<input type="text" name="name"><br>  
Password:<input type="password" name="password"><br> 
Mob no:<input type="number" name="mob"><br>
Email:<input type="text" name="email"><br>  
<input type="submit" value="SIGNUP">  
</form>
</center>

</body>
</html>