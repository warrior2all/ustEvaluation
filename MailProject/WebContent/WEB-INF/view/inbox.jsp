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
	<h1 >Inbox</h1>
 <hr>
<table style="background-color:white" border='1' align="center">
<tr><th>Message</th><th>delete</th></tr>
<c:forEach var="dto" items="${msg}">
<tr><td><a href="inboxedit?id=+${dto.getMid()}+">message</a></td><td><a href="delete?id=+${dto.getMid()}+">Delete</a></td></tr>
</c:forEach>
</table> 


<a   href="compose">Compose</a>|
<a   href="sentMail">Sent</a>|
<a   href="inboxMail">Inbox</a>|
<a   href="draftMail">Draft</a>|
<a   href="logout">logout</a>|
<a   href="deletemessage">deletemessage</a>|

</body>
</html>