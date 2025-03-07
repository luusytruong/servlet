<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action=<%=request.getContextPath() + "/contact"%>>
		<h2>New Contact</h2>
		<span>phone number</span> <input name='phone'> <br> 
		<span>name contact</span> <input name='name'> <br> 
		<input type='submit'>
	</form>
</body>
</html>