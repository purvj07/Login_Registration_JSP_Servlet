<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h3 align="center">This is ADMIN Page</h3>


<%
	  if(session.getAttribute("user") == null){
		  
		  response.sendRedirect("login.jsp");
	  }
	
	%>
<br>


<h4>Profile</h4>
<a href="UserController">LIST</a>
 <br>

<c:forEach var="u" items="${userslist}"><br>

<c:out value = "${u}" /> 

</c:forEach>

  <br>
 

</body>


