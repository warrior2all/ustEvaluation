<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<a href="search">Search Product</a> | <a   href="add">Add Product </a> | <a   href="addtocart">Items for cart</a> | <a  href="allproduct">All Products/Update</a> | <a   href="Home">Home </a></h3>
<body>
<h3 align="right" >${user}</h3> <br><br>
 <ahref="logout">LOGOUT</a>
<hr>


<h1 style="font-size: 50px;">Add Product</h1>
<fieldset style="width:350px;">
<form action="addproduct"  method="post" >
<pre>
<h3><b>
  Name:	   	 <input style="width: 200px" type="text" name="pname"  required="required" ><br>
Category:	    <input style="width: 200px" type="text" name="pcategory"   required="required"><br>
Company: 	    <input style="width: 200px" type="text" name="pcompany"  required="required"><br>
Quantity: 	    <input style="width: 200px" type="text" name="pquantity"  required="required"><br>
  Price:		<input style="width: 200px" type="number" name="price"  required="required"><br><br>
<input type="submit" value="Add Product">    
 </b></h3> 

</form>
<h3 align="center" style="font-size: 30px">${msg }</h3>
</fieldset>

</body>
</html> 