<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="a.css">
<script type="text/javascript">
 <!--
            function sayHello() {
               document.write("Hello World");
            }
         //-->
</script>
</head>
<nav>
  <ul>
    <li>
       <input type="button" onclick="document.location.href ='Hservlet'" value="home"/>
    </li>
    <li>
      <input type="button" onclick="document.location.href ='Prfserv'" value="profile">
    </li>
    <li>
      <input type="button" onclick="alert('nothing_implemented')" value="something">
    </li>
    <li>
      <input type="button" onclick="alert('nothing_implemented')" value="something">
    </li>
    <li>
      <input type="button" onclick="document.location.href ='Loutserv'" value="logout">
    </li>
  </ul>
</nav>
</html>