<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center;">Welcome to Login page</h1>
<hr>
<fieldset style=width=10px border='2' >
<form style="text-align:center" width=10px ; action="logIn" method="post">
        
        <div>
            <label for="">username</label><br>
            <input type="text" name="username">
        </div><br>
        
        <div>
            <label for="">password</label><br>
            <input type="password" name="password">
        </div><br>
        
    
        <div>
            <input type="submit" value="login">
            <input type="reset" value="Reset">
        </div>
        
    </form></fieldset>
    <div style="text-align:center">
    <a href="changePass">ChangePassword</a>  |  <a href="forgetPassword">Forget Password?</a>
    </div>
    <h3>${msg }</h3>

</body>
</html>