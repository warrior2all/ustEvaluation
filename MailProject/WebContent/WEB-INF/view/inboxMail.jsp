<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">*************view Inbox**************</h2>
<hr>
<table style="background-color:white" border='1' align="center">  
<tr><th>sender</th><th>message</th> </tr>
<c:forEach var="mdto" items="${msg}">
<tr><td>${mdto.getFrom_id()}</td><td>${mdto.getInbox()}</td></tr></table>
</c:forEach>

<a   href="compose">Compose</a>|
<a   href="sentMail">Sent</a>|
<a   href="inboxMail">Inbox</a>|
<a   href="draftMail">Draft</a>|
<a   href="logout">logout</a>|
<a   href="deletemessage">deletemessage</a>|
</body>
</html>