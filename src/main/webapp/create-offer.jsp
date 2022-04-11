<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
String name=(String)httpSession.getAttribute("adminname");
String role=(String)httpSession.getAttribute("userrole");
if(name!=null && role.equalsIgnoreCase("admin"))%><%{%>
	
	<%@ include file="admin-navbar.jsp" %>
<h1 align="center">CreateOffer</h1>
<div class="container">
  <form:form action="saveoffer" modelAttribute="offer">
    <div class="row">
      <div class="col-25">
        <label for="fname"> cost</label>
      </div>
      <div class="col-75">
        <form:input type="number" id="fname" placeholder="cost.." path="cost"/>
      </div>
    </div>
     <div class="row">
      <div class="col-25">
        <label for="fname"> offer</label>
      </div>
      <div class="col-75">
        <form:input type="number" id="fname"  placeholder="offer.." path="offer"/>
      </div>
    </div>
      <div class="row">
      <div class="col-25">
        <label for="fname"> GST</label>
      </div>
      <div class="col-75">
        <form:input type="number" id="fname"  placeholder="GST.." path="GST"/>
      </div>
    </div>
      <div class="row">
      <div class="col-25">
        <label for="fname"> SGST</label>
      </div>
      <div class="col-75">
        <form:input type="number" id="fname"  placeholder="SGST.." path="SGST"/>
      </div>
    </div>
     

 
    <div class="row">
      <input type="submit" value="Submit">
    </div>
  </form:form >
</div>
<%}
%>
</body>
</html>