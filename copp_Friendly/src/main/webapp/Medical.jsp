<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="copp_Friendly.mvc.util.DBConnection"%>
<%
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Team</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid h-100">
<div class="row " style="height:10%;background-color:black;color:white;"><div class="col-sm-10" >
<h1> 
      <span style="color:lightgray">Medical Team</span> </h1></div>
      <a href="LogoutServlet"><button class="btn btn-success pull-right"  style="margin:1%" > 
        Logout
          </button> </a></div>
 
</div>
<div class="row h-100" >
<%
try{ 
	
connection = DBConnection.createConnection();
statement=connection.createStatement();
String sql ="SELECT * FROM emergency ORDER BY sln desc";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<br>
<form name="form" action="MedicalServlet" method="POST" style="margin:3%" >
<table align="center" cellpadding="5" cellspacing="5" border="2" >
<tr>
<td>Emergency ID : </td>
<td name="numaffec"><%=resultSet.getInt("sln") %></td>
</tr>
<tr >
<td>Number_of_affected : </td>
<td name="numaffec"><%=resultSet.getInt("Number_of_affected") %></td>
</tr>
<tr>
<td>Number_of_emergency : </td>
<td name="numem"><%=resultSet.getInt("Number_of_emergency") %></td>
</tr>
<tr >
<td>Location : </td>
<td name="location"><%=resultSet.getString("location") %></td>
</tr>
</table>
<input type="submit"  value="send">
</form>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>

 </div>  
</body>
</html>