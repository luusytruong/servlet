<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>New Contact</h2>
<form method="post" action=<%= request.getContextPath() + "/test_session" %>>
	phone number: <input name= "phone"><br>
	name contact: <input name= "name"><br>
	<input type= "submit">
</form>
</body>
</html>