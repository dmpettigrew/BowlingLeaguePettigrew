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
<form method="post" action = "viewAllPlayersServlet">
<table>
<c:forEach items ="${requestScope.allPlayers}" var="currentplayers">
<tr>
	<td><input type="radio" name="playerId" value="${currentart.playerId}"></td>
	<td>${currentart.firstName}</td>
	<td>${currentart.lastName}</td>
	<td>${currentart.phoneNumber}</td>
	<td>${currentart.screenName}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "Delete Selected Player" name = "doThisToArt">
<input type = "submit" value = "Add New Player" name = "doThisToArt">
</form>
</body>
</html>