<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 >Compose your message here!!!</h1>
<h3>${msg }</h3>
	<hr>
	<form style="text-align:center;"action="composemail"  method="post">
		<div>
		
			<label for="to">To</label> <br> <input type="text"
				name="to" id="to">

		</div>

		<div>
			<label for="msg">Message</label> <br>
			<textarea name="msg" id="msg"></textarea>
			
		</div>
		<div >
			<input type="Submit" value="Send">
		</div></form>
		
<a   href="compose">Compose</a>|
<a   href="sentMail">Sent</a>|
<a   href="inboxMail">Inbox</a>|
<a   href="draftMail">Draft</a>|
<a   href="logout">logout</a>|
<a   href="deletemessage">deletemessage</a>|

</body>
</html>