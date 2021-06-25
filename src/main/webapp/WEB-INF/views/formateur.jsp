<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Formateur Page</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/formateur.css">
</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/logout">Go to Logout</a>
	</p>
	<form action="reserve" method="GET">
		<h2>Add Activity</h2>
		<tr>
			<td style="font-style: italic">${Nom}</td>
			<td style="font-style: italic">${Prenom}</td>
		</tr>
		<label>Pick a date:</label> <input type="date" id="date" name="date"><br>
		<label for="type">Choose a type:</label> <select name="type" id="type">
			<option value="Event">Event</option>
			<option value="Competition">Competition</option>
			<option value="Hackathon">Hackathon</option>
		</select> <br> <input type="submit" value="Submit">
	</form>

	<div class="wrapper">
		<div class="header">
			<h2>List d'activities</h2>
		</div>

		<div class="content">
			<table>
				<tr>
					<th>Activity</th>
					<th>Date</th>
				</tr>
				<c:forEach var="tempType" items="${listActivities}">
					<tr>
						<td>${tempType.date}</td>
						<%-- <td>${tempType.activities}</td> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>