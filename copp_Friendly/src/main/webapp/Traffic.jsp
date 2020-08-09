
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="copp_Friendly.mvc.bean.RegisterBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Register</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script> 
function validate()
{ 
     var fullname = document.form.fullname.value;
     var phone = document.form.phone.value;
     var location = document.form.location.value; 
     var roffender = document.form.roffender.value;
     var license= document.form.license.value;
     var vehicle= document.form.vehicle.value;
     
     if (fullname==null || fullname=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (phone==null || phone=="")
     { 
     alert("Phone Number can't be blank"); 
     return false; 
     }
     else if (location==null || location=="")
     { 
     alert("Location can't be blank"); 
     return false; 
     }
     else if(license==null || license=="")
     { 
     alert("License can't be blank"); 
     return false; 
     } 
     else if(roffender==null || roffender=="")
     { 
     alert("Reapeted Offender can't be blank"); 
     return false; 
     } 
     else if(vehicle==null || vechile=="")
     { 
     alert("Vechile can't be blank"); 
     return false; 
     } 
 } 
function validate1()
{ 
     var numem = document.form.numem.value;
     var numaffec = document.form.numaffec.value;
     var latitude = document.form.latitude.value; 
     var longitude = document.form.longitude.value;
     
     if (numem==null || numem=="")
     { 
     alert("No of emergency can't be blank"); 
     return false; 
     }
     else if (numaffec==null || numaffec=="")
     { 
     alert("No of affected can't be blank"); 
     return false; 
     }
     else if (latitude==null || latitude=="")
     { 
     alert("Latitude can't be blank"); 
     return false; 
     }
     else if (longitude==null || longitude=="")
     { 
     alert("Longitude can't be blank"); 
     return false; 
     }
     
 } 
</script>
<style>
body, html {
    height: 100%;
}
.divider-text {
    position: relative;
    text-align: center;
    margin-top: 15px;
    margin-bottom: 15px;
}
.divider-text span {
    padding: 7px;
    font-size: 12px;
    position: relative;   
    z-index: 2;
}
.divider-text:after {
    content: "";
    position: absolute;
    width: 100%;
    border-bottom: 1px solid #ddd;
    top: 55%;
    left: 0;
    z-index: 1;
}

.btn-facebook {
    background-color: #405D9D;
    color: #fff;
}
.btn-twitter {
    background-color: #42AEEC;
    color: #fff;
}
</style>
</head>
<div class="container-fluid h-100">
	<div class="row " style="height:10%;background-color:black;color:white;"><div class="col-sm-10" >
<h1> 
      <span style="color:lightgray">Traffic Inspecter/Officer</span> </h1></div>
      <div class="col-sm-2"><a href="NotificationServlet?username=${username}&num=2&date=<%= (new java.util.Date()).toLocaleString()%>"><button class="btn btn-success pull-right" style="margin:1%;float:left" > 
        SOS 
          </button></a> <a href="LogoutServlet"><button class="btn btn-success pull-right"  style="margin:1%" > 
        Logout</button></a></div>
 
</div>
<div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Register</a>
  <a class="navbar-brand" href="NotificationServlet?username=${username}&num=0">Notifications</a>
</nav>
</div>
    <div class="row h-100" style="height:90%;">
    <div class="col-lg-6 col-xs-12  py-2 d-flex align-items-center justify-content-center " style="height:90%;" id="right">
            <div class="container">
<div>
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Register Emergency</h4>
	<form name="form" action="RegisterEServlet" method="post" onsubmit="return validate()">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input class="form-control" name="numem" placeholder="No of emergency" type="text">
    </div> 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input class="form-control"name="numaffec" placeholder="Number of affected" type="text">
    </div>     
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Location" name="location" type="text">
    </div> 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Latitude" name="latitude" type="text">
    </div> 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" name="longitude" placeholder="Longitude" type="text">
    </div>     
    	<div class="form-group input-group">
    		<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
    </div>                                   
    <div class="form-group">
        <input type="submit" class="btn btn-primary btn-block" value="Register">
    </div>                                                                     
</form>
</article>
</div> 

</div> 

        </div>

        <div class="col-lg-6 col-xs-12 py-2 d-flex align-items-center justify-content-center " style="height:90%;" id="left">
            
<div class="container">
  <br><br><br><br>
<div>
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Register Violation</h4>
	<form name="form" action="RegisterServlet" method="post" onsubmit="return validate1()">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="fullname" class="form-control" placeholder="Full name" type="text">
    </div> 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Vehicle" name="vehicle" type="text">
    </div> 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="license" class="form-control" placeholder="License" type="text">
    </div> 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="type" class="form-control" placeholder="Violation type" type="text">
    </div> 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Location" name="location" type="text">
    </div> 
	<div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="latitude" class="form-control" placeholder="Latitude" type="text">
    </div>
	<div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="longitude" class="form-control" placeholder="Longitude" type="text">
    </div>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>	    
		
    	<input name="phone" class="form-control" placeholder="Phone number" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>	    
		
    	<input name="fine" class="form-control" placeholder="Fine Amount" type="text">
    </div> 
    <div class="form-group input-group">
    <p>Repeated Offender : </p>
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<select class="form-control" name="roffender" id="roffender">
			<option selected="">-- Select --</option>
			<option>Yes</option>
			<option>No</option>
		</select>
	</div> 
    <div class="form-group input-group">
        <%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%>
    </div>                                    
    <div class="form-group">
        <input type="submit" class="btn btn-primary btn-block" value="Register">
    </div>                                                                     
</form>
</article>
</div> 

</div> 


<br><br>

        </div>
    </div>
</div>
</html> 