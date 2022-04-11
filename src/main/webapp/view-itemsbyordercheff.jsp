<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%@ include file="cheff-navbar.jsp" %>
<table align="center" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Cost</th>
			
			
			
		</tr>
		
		
		<c:forEach items="${orders}" var="prod">

			<tr>
				<td>${prod.itemId}</td>
				<td>${prod.name}</td>
				<td>${prod.cost}</td>
				
				
				
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>