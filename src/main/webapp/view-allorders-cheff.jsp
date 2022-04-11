<%@page import="com.ty.dto.Orders"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}
</style>
</head>
<body>
<% HttpSession httpSession=request.getSession();
String name=(String)httpSession.getAttribute("cheffname");
String role=(String)httpSession.getAttribute("userrole");
if(name!=null && role.equalsIgnoreCase("cheff"))%><%{%>
	<%@ include file="cheff-navbar.jsp" %>
	<table align="center" border="1">
		<tr>
			
			<th>OrderID</th>
			<th>Status</th>
			<th>View Item</th>
			<th>Update Order</th>


		</tr>
		
	<c:forEach items="${orders}" var="orders">

			<tr>
				<td>${orders.orderId}</td>
				<td>${orders.status}</td>
		
				<td><a href="getitemsbycheff?orderId=${orders.orderId}">view</a></td>
				<td><a href="updateorderbycheff?orderId=${orders.orderId}">updateOrder</a>
			</tr>
		</c:forEach>
</table>
<%} %>
</body>
</html>