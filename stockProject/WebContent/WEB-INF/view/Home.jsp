<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h1 align="center">Home page</h1>
<br><br>
<h3 align="right" >${user} <br><br></h3>
<h4><a  href="logout">LOGOUT</a></h4> 
<hr>


<a   href="search">Search Product</a> | <a   href="add">Add Product </a> | <a   href="ShowCart">Show Cart </a> | <a  href="addtocart">Items for cart</a> | <a   href="allproduct">All Products/Update</a>
<h4 align="center">${msg}</h4>
</body>
</html>