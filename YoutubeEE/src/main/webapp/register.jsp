<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JavaEE Project</title>
</head>
<body>
	<h1>Bitte registriere Dich - Register Formular</h1>
	<p>Bitte gib deinen Username und dein Passwort ein</p>
	<form method="post" action="register">
		<label for="username">Username:</label><br>
		<input type="text" id="username" name="username"><br>
		<label for="password">Password:</label><br>
		<input type="password" id="password" name="password"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>