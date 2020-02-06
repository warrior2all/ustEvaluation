<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Forget Password</h1>
<form action="forget" align="center" method="post">
			
			<div >	<label for="email">
			
				email</label> <br> <input type="text"name="email" id="username">
					
			</div>
			<h4>security question</h4>
			<div>
            <label for="">security Question</label><br>
            <select style="width:150px;"name="question" id="">
                <option value=""selected disabled>select</option>
                <option value="what is your birth place ?">what is your birth place ?</option>
                <option value="what is your nick name ?">what is your nick name ?</option>
                <option value="what is your favourite game ?">what is your favourite game ?</option>
                <option value="your first school is ?">your first school is ?</option>
                
            </select>
        </div><br>
        
        <div>
            <label for="">answer</label><br>
            <input type="text" name="answer">
        </div>

			
			<div>
			<div ><label for="password">

				new password</label> <br> <input type="text" name="newpassword" id="np">
			</div>
					<div>
				<button type="submit">Submit</button>
			</div>

</body>
</html>