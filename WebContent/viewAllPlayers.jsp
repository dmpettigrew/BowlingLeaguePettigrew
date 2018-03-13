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
<form method="post" action = "editPlayerServlet">
<table>
<c:forEach items ="${requestScope.allPlayers}" var="currentplayers">
<tr>
	<td><input type="radio" name="playerId" value="${currentplayers.playerId}"></td>
	<td>${currentplayers.firstName}</td>
	<td>${currentplayers.lastName}</td>
	<td>${currentplayers.phoneNumber}</td>
	<td>${currentplayers.screenName}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "Edit Selected Player" name = "doThisToPlayer">
<input type = "submit" value = "Delete Selected Player" name = "doThisToPlayer">
<input type = "submit" value = "Add New Player" name = "doThisToPlayer">
</form>
<a href = "index.html"> Back to List</a><br />
</body>
</html>