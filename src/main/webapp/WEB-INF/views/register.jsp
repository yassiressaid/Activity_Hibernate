<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page session="false"%>
<html>
<head>
<title>Register</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
	<form action="registerProsses" method="GET">
		<input type="text" name="Nom" placeholder="Nom" /><br /> <input
			type="text" name="Prenom" placeholder="Prenom" /><br /> <input
			type="text" name="Email" placeholder="Email" /><br /> <input
			type="text" name="Password" placeholder="Password" /><br /> <input
			type="submit" value="register" /><br> <a href="/activityApp/">login</a>
	</form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${massage}</td>
		</tr>

</body>
</html>
