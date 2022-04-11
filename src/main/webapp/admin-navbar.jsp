<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* Add a black background color to the top navigation */
.topnav {
  background-color: rgb(255, 212, 128);
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
h2{
font-size: 17px;
  color: black;
}
</style>
</head>
<body>
<% HttpSession httpSessioni=request.getSession();
String name1=(String)httpSessioni.getAttribute("adminname"); %>
<div class="topnav">
  <a href="admin-home.jsp">Home</a>
  <a href="createuser">Create Staff</a>
  <a href="displayuser">View Staff</a>
  <a href="createproduct">Create Product</a>
  <a href="viewproduct">View Product</a>
  <a href="createoffer">Create Offer</a>
  <a href="displayoffer">View Offer</a>
  <a href="logout">Logout</a>
  <h2 align="right"><%=name1 %></h2>
</div>
</body>
</html>