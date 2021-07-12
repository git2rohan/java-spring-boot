<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Insert Users - </h2>
	<form action="adduser" method="post">
		 <input type="text" name="name" placeholder="username"> <input type="submit"><br>
	</form>

<h2>Select Users - </h2>
	<form action="getuser">
		get user by Id: <input type="number" name="id"> 
		<input type="submit" value="fetch by id">
	</form>

	<br>
	<form action="getuserbyname">
		get user by name: <input type="text" name="name"> 
		<input type="submit" value="fetch by name">
	</form>
	<br>
	<form action="getuserbyidgt">
		get users where id is greater than : <input type="number" name="id"> 
		<input type="submit" value="fetch by id greater than">
	</form>
	<br>
	<h2><a href="getallusers">fetch all users</a></h2>
	
	<h2>Update user - </h2>
	
	<form action="updateuser" method="post">
		 <input type="text" name="id" placeholder="userid">
		 <input type="text" name="name" placeholder="username">
		  <input type="submit"><br>
	</form>
	
	<h2>Delete user</h2>
	<form action="deleteuser" method="post">
		 <input type="text" name="id" placeholder="userid"> <input type="submit"><br>
	</form>
	
	
</body>
</html>