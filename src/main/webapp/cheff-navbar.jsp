<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<% HttpSession session2=request.getSession();
	String name1=(String)session2.getAttribute("cheffname");
%>

<div class="topnav">
  <a  href="cheff-home.jsp">Home</a> 
   <a href="viewallorderbycheff">View All Order</a> 
  <a  href="logout" >Logout</a>
  <h2 align="right"><%=name1 %></h2>
</div>
</body>
</html>