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
  <caption>User Details</caption>
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Email ID</th>
       <th scope="col">Password</th>
      <th scope="col">Role</th>
       <th scope="col">phone</th>
        <th scope="col">edit</th>
          <th scope="col">delete</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${users}" var="user">
<tr>
<td >${user.id }</td>
<td >${user.name }</td>
<td >${user.email }</td>
<td >${user.password }</td>
<td >${user.role }</td>
<td >${user.phone }</td>
<td ><a href="edituser?id=${user.id}">edit</a></td>
<td ><a href="deleteuser?id=${user.id}">delete</a></td>
</tr>
</c:forEach>
  </tbody>
</table>
<%} %>
</body>
</html>