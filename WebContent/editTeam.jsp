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
<form action = "completeEditOfTeamServlet" method="post">
Team Name: <input type = "text" name = "teamName" value= "${teamToEdit.teamName}">
Team Type: <input type = "text" name = "teamType" value= "${teamToEdit.teamType}">
Preferred Night: <input type = "text" name = "preferredNight" value= "${teamToEdit.preferredNight}">
<input type = "hidden" name = "id" value= "${teamToEdit.teamId}">
<input type = "submit" value="Save Edited Team">
</form>
<a href = "index.html"> Back to List</a><br />
</body>
</html>