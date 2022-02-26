<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.youtube.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JavaEE Project</title>
</head>
<body>
	<h1>Willkommen zum JavaEE Tutorial. </h1> 
	<%
	    HttpSession ses = request.getSession();
		User user =  (User) ses.getAttribute("loggedUser");
		out.println("Ich begrüße Dich: " + user.getUsername());
	%>

</body>
</html>