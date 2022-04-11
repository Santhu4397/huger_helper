<%@page import="com.ty.dto.Product"%>
<%@page import="com.ty.dto.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        
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
String name=(String)httpSession.getAttribute("staffname");
String role=(String)httpSession.getAttribute("userrole");
if(name!=null && role.equalsIgnoreCase("staff"))%><%{%>
<%@ include file="staff-navbar.jsp" %>

<form:form action="placeorder">
<table align="center" border="1">
		<tr>
			
			<th>Item_Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
		
		List<Item> items=(List<Item>)session.getAttribute("items");
		
		%>
	 <%
		for(Item list:items) {
		%>
			
			<tr>
			
			<td><%=list.getName()%></td>
				<td><%=list.getCost()%></td>
				
				<td><%=list.getQuantity()%></td>
					
	</tr>
	<%
		}
	%>
              <tr>      <td colspan="4" align="center" > <input type="submit" value="submit"> </td>
                </tr>
	</table>
</form:form>
<%} %>

</body>
</html>