<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page session="false"%>
<html>
<head>
<title>Login</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
	<form action="login" method="GET">

		<input type="text" name="Email" placeholder="Email" /><br /> <input
			type="text" name="Password" placeholder="Password" /><br /> <input
			type="submit" value="login" /><br> <a href="register">register</a><br>
		<table align="center">
			<tr>
				<td style="font-style: italic; color: red;">${msg}</td>
			</tr>
		</table>

	</form>

</body>
</html>
