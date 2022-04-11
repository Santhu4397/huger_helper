<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</style>
</head>
<body>
<% HttpSession httpSession=request.getSession();
String name=(String)httpSession.getAttribute("staffname");
String role=(String)httpSession.getAttribute("userrole");
if(name!=null && role.equalsIgnoreCase("staff"))%><%{%>
<%@ include file="staff-navbar.jsp" %>
<h1 align="center"> Staff Home Page</h1>
<%} %>
</body>
</html>