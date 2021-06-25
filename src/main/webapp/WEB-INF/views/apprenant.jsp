<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List d'activities</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/formateur.css">
</head>
<body>
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