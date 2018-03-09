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
<form method="post" action = "viewAllTeamsWithPlayersServlet">
<table>
<c:forEach items ="${requestScope.allTeams}" var="currentteams">
<tr>
	<td><input type="radio" name="teamId" value="${currentart.teamId}"></td>
	<td>${currentart.teamName}</td>
	<td>${currentart.teamType}</td>
	<td>${currentart.preferredNight}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "Edit Selected Team" name = "doThisToTeam">
<input type = "submit" value = "Delete Selected Team" name = "doThisToTeam">
<input type = "submit" value = "Add New Team" name = "doThisToTeam">
</form>
</body>
</html>