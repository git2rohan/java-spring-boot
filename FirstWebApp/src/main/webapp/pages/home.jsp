<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hey, this is spring boot -> ${user.name}<br>
<a href="/profile?userId=${user.id}">go to profile</a>


</body>
</html>