<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "completeEditOfPlayerServlet" method="post">
Player First Name: <input type = "text" name = "firstName" value= "${playerToEdit.firstName}">
Player Last Name: <input type = "text" name = "lastName" value= "${playerToEdit.lastName}">
Player Phone Number: <input type = "text" name = "phoneNumber" value= "${playerToEdit.phoneNumber}">
Player ScreenName: <input type = "text" name = "screenName" value= "${playerToEdit.screenName}">
Team: <input type = "text" name = "team" value= "${playerToEdit.team}">
<input type = "hidden" name = "playerId" value= "${playerToEdit.playerId}">
<input type = "submit" value="Save Edited Player">
</form>
<a href = "index.html"> Back to List</a><br />
</body>
</html>