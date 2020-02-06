<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 >Registration</h1>
<fieldset>

<form action="MangerRegistration"  method="post" >
<pre>

Username:	    <input  type="text" name="mname"  required="required" ><br>
Mobile No.:	    <input type="tel" name="mnumber"   maxlength="10" ><br>
Email Id: 	    <input  type="email" name="email"  required="required"><br>
Password: 	    <input  type="password" name="password"  required="required"><br><br>
<input  type="submit" value="register">   |  <a  href="Login">Login</a> 
 </b></h3> 
</pre>
</form>
<h3>${msg }</h3>
</fieldset>

</body>
</html>