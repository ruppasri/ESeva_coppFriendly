<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="copp_Friendly.mvc.util.DBConnection"%>
<%@page import="copp_Friendly.mvc.bean.RegisterBean"%>
<%
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
connection = DBConnection.createConnection();
Statement stat = null;
ResultSet res = null;
stat=connection.createStatement();
res=stat.executeQuery("select sum(fine) as sum from violation ;");
res.next();
int fine=res.getInt("sum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CENTRAL TEAM</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid h-100">
<div class="row " style="height:10%;background-color:black;color:white;"><div class="col-sm-10" >
<h1> 
      <span style="color:lightgray">Central Team</span> </h1></div>
      <a href="LogoutServlet"><button class="btn btn-success pull-right"  style="margin:1%" > 
        Logout
          </button> </a></div>
 
</div>
<div >
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Violations</a>
  <a class="navbar-brand" href="NotificationC.jsp">SOS Notifications</a>
</nav>
</div>
<div>
<h5 style="text-align:center">Total Fine Collected : <%=fine %></h5>
</div>
<div class="row h-100" >
<%
try{ 
statement=connection.createStatement();
String sql ="SELECT * FROM violation ORDER BY sln desc";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<br>
<table align="center" cellpadding="5" cellspacing="5" border="2">
<tr>
<td>Violation ID : </td>
<td><%=resultSet.getInt("sln") %></td>
</tr>
<tr >
<td>Full Name : </td>
<td><%=resultSet.getString("fullname") %></td>
</tr>
<tr >
<td>Phone Number : </td>
<td><%=resultSet.getString("phone") %></td>
</tr>
<tr >
<td>Location : </td>
<td><%=resultSet.getString("location") %></td>
</tr>
<tr >
<td>License ID: </td>
<td><%=resultSet.getString("license") %></td>
</tr>
<tr >
<td>Vehicle Used : </td>
<td><%=resultSet.getString("vehicle") %></td>
</tr>
<tr >
<td>Fine Collected : </td>
<td><%=resultSet.getInt("fine") %></td>
</tr>
<tr >
<td>Whether he/she is a <br>repeated offender : </td>
<td><%=resultSet.getString("roffender") %></td>
</tr>
</table>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</div>
</body>
</html>