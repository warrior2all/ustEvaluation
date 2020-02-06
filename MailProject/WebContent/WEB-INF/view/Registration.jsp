<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center;">Welcome to Registration page</h1>
<hr>

<form style="text-align:center;" action="SignUp" method="post">
        <div>
            <label for="Name">Name</label><br>
            <input type="text" name="name" id="Name">
        </div><br>
        <div>
            <label for="">username</label><br>
            <input type="text" name="username">
        </div><br>
        <div>
            <label for="Email">Email</label><br>
            <input type="email" name="email" id="Email">
        </div><br>
        <div>
            <label for="">password</label><br>
            <input type="password" name="password">
        </div><br>
        
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
            <input type="checkbox" name="check">
            <label for="">I agree to terms and conditions</label>
        </div>
        <div>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
        
    </form>
    <h4>${msg }</h4>
    <a href="login">Login</a>
   

</body>
</html>