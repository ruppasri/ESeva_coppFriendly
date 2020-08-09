<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="copp_Friendly.mvc.util.DBConnection"%>
<%@ page import="copp_Friendly.mvc.bean.RegisterBean" %>
<%
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>CoppFriendly</title>
</head>
<body>
<div class="container-fluid h-100">
	<div class="row " style="height:10%;background-color:black;color:white;"><div class="col-sm-10" >
<h1> 
      <span style="color:lightgray">Central Team</span> </h1></div>
      <div class="col-sm-2"> <a href="LogoutServlet"><button class="btn btn-success pull-right"  style="margin:1%" > 
        Logout
          </button> </a></div>
 
</div>
<div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="Central.jsp">Violations</a>
  <a class="navbar-brand" href="#">SOS Notifications</a>
</nav>
</div>
<div class="row h-100" >
<div class=" col-lg-2"></div>
<div class="col-lg-8 col-xs-12" >

<%
try{ 

connection = DBConnection.createConnection();
statement=connection.createStatement();
String sql ="SELECT sln,name,location,date FROM sos ORDER BY sln desc";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<br>
<form name="form" action="CentralServlet" method="POST">
<h3><%=resultSet.getInt("sln") %></h3>
<h3 id="name"> <%=resultSet.getString("name") %></h3>
<h5 id="location"><%=resultSet.getString("location") %></h5>
<h5 id="date"><%=resultSet.getString("date") %></h5>
<input type="submit" value="send">
</form>
<hr>


<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</div>
<div vlass="row h-100 col-lg-2"></div>
</div>
</div>
</body>
</html>