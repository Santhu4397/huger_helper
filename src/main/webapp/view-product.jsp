<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}
</style>
</head>
<body>
<% HttpSession httpSession=request.getSession();
String name=(String)httpSession.getAttribute("adminname");
String role=(String)httpSession.getAttribute("userrole");
if(name!=null && role.equalsIgnoreCase("admin"))%><%{%>
<%@ include file="admin-navbar.jsp" %>
<table align="center" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Type</th>
			<th>Cost</th>
			<th>Food_Type</th>
			<th>Image</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		
		
		<c:forEach items="${product}" var="product">

			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.type}</td>
				<td>${product.cost}</td>
				<td>${product.foodtype}</td>
				<td><img src="${product.imagelink}" length="70" width="70"></td>
				<td><a href="editproduct?id=${product.id}">edit</a></td>
				<td><a href="deleteproduct?id=${product.id}">delete</td>
			</tr>
		</c:forEach>
	</table>
<%} %>
</body>
</html>