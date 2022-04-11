<%@page import="com.ty.dto.Orders"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body {
  background-image: url('https://cdn.pixabay.com/photo/2017/10/22/21/24/knife-2879328_1280.jpg');
  background-repeat: no-repeat;
  background-attachment:scroll;  
  background-size: cover;
}

th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

td {
  border: 1px solid #ddd;
  padding: 8px;
}

tr{
background-color: rgb(255, 238, 204);}

tr:hover {background-color: #ddd;}

* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
</head>
<body>
<% HttpSession httpSession=request.getSession();
String name=(String)httpSession.getAttribute("cheffname");
String role=(String)httpSession.getAttribute("userrole");
if(name!=null && role.equalsIgnoreCase("cheff"))%><%{%>
<%@ include file="cheff-navbar.jsp" %>
<form:form action="updateorderbyidcheff" modelAttribute="orders">
	<table align="center" border="1">
		

			<tr>
			<tr><td>Order Id</td><td><form:input path="orderId" /><br><br><td></tr>
			<tr><td>Customer Name</td><td><form:input path="customer_name" /><br><br><td></tr>
			<tr><td>Customer Phone</td><td><form:input path="customer_phone" /><br><br><td></tr>
			<tr><td>Status</td>
			
				<td><form:radiobutton path="status" value="Order placed"/>Order placed
				<form:radiobutton path="status" value="under process"/>under process
				<form:radiobutton path="status" value="ready"/>ready
				<form:radiobutton path="status" value="Delivered"/>Delivered
				<br><br></td>
				<tr><td>Total cost</td><td><form:input path="totalCost" /><br><br><td></tr>
			
			</table>
			<input type="submit" value="update">
			</form:form>
			<%} %>

</body>
</html>