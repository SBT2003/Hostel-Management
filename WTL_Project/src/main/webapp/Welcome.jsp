<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Expires","0");
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}
	%>
	Welcome ${username}
	<h1>Good to see you</h1>
	<form action="Logout">
	<input type="submit" value="Logout">
	</form>

</body>
</html>