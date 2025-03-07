<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>List Contacts</h2>
	<ol>
		<c:forEach var="contact" items="${sessionScope.contacts }">
			<li>phone number: ${contact[0]}, name contact: ${contact[1]}</li>
		</c:forEach>
	</ol>
</body>
</html>