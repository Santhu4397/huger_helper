<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
String name=(String)httpSession.getAttribute("adminname");
String role=(String)httpSession.getAttribute("userrole");
if(name!=null && role.equalsIgnoreCase("admin"))%><%{%>
<%@ include file="admin-navbar.jsp" %>
<table align="center" border="1">
  <caption>Offers and Taxs Details</caption>
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Cost</th>
      <th scope="col">Offers</th>
       <th scope="col">GST</th>
      <th scope="col">SGST</th>
        
          <th scope="col">delete</th>
    </tr>
  </thead>
  <tbody>
  
     <c:forEach items="${Offers}" var="offer">
<tr>
<td>${offer.offerId }</td>
<td>${offer.cost }</td>
<td>${offer.offer }</td>
<td>${offer.GST }</td>
<td>${offer.SGST }</td>
<td><a href="deleteoffer?id=${offer.offerId}">delete</a></td>
</tr>
</c:forEach>
    
	  
	
    
  </tbody>
</table>
<%} %>
</body>
</html>