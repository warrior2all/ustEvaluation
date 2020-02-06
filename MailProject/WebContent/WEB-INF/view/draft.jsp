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

<h1 >******************Draft******************</h1>
 <hr>
<%-- <c:forEach var="msg" items="${msg}">
<h4>${msg. getDraft() }</h4>
</c:forEach>

	<h1 align="center">Draft</h1>
	<hr>  --%>
	
<table style="background-color:white" border='1' align="center">
<tr><th>Message</th> <th>Draft</th> <th>edit</th> </tr>
<c:forEach var="dto" items="${msg}">
<tr><td>${dto.getDraft_message()}</td><td>${dto. getDraft()}</td><td><a href="editDraft?id=+${dto.getMid()}">edit</a></td></tr>
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