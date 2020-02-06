<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style=" font-size: 50px;"><b><i>All Products Available</b></i></h1>
<br><br>

<a   href="search">Search Product</a> | <a   href="add">Add Product </a> | <a href="addtocart">Items for cart</a> | <a  href="allproduct">All Products/Update</a> |  <a  href="Home">Home</a></h3>
<h1 align="center">${msg}</h1>
<h3 align="right" >${user}</h3> <br><br>
 <a href="logout">LOGOUT</a>
<hr>

<table border='1'><tr><th>Product Name</th><th>Product Category</th><th>Company Name</th> <th>Quantity</th><th>Price</th><th>Update</th></tr>
<c:forEach var="mdto" items="${mlist}">
<form action="updateProduct" method="post">
<tr>
<input type="hidden" name="pid" value=" ${mdto.getPid() }">
<td><input type="text" name="pname" value="${mdto.getPname() }"></td>
<td> <input type="text" name="pcategory" value="${mdto.getPcategory() }"></td>
<td><input type="text" name="pcompany"  value="${mdto.getPcompany() }"></td>
<td><input type="text" name="pquantity" value="${mdto.getPquantity() }"></td>
<td><input type="text" name="price" value="${mdto.getPrice() }"></td> 
<td><input type="submit" value="Update"></td>
</tr>
</form>
</c:forEach>
</table>

</body>
</html>
