<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="Login.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script> 
function validate()
{ 
     var username = document.form.username.value; 
     var password = document.form.password.value;
     request.setAttribute("name",username);
     if (username==null || username=="")
     { 
     alert("Username cannot be blank"); 
     return false; 
     }
     else if(password==null || password=="")
     { 
     alert("Password cannot be blank"); 
     return false; 
     } 
}
</script> 
</head>
<body>
	
    <div class="containar">

    <div class="contact-form">
        <img src="police.png" class="avatar">
        <h2>Login</h2>
        <form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password">
	    
	    <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
            <input type="submit" value="Login"><input
         type="reset" value="Reset"></input>
        </form>
    </div>
    </div>
</body>
</html>
