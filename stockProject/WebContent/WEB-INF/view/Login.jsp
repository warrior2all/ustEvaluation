<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>LOGIN</h1>

<form action="ManagerLogin"  method="post" >

Email Id:  <input type="email" name="email"  required="required"><br>
Password: <input type="password" name="password"  required="required"><br><br>
<input  type="submit" value="Login"> | <a href="Register">Register</a> 

</form>


<h3>${msg}</h3>

</body>
</html>