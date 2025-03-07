<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Contact List</h2>
	<ol>
		<c:forEach var="contact" items="${sessionScope.contacts}">
			<li>phone: ${contact[0]}, name: ${contact[1]}</li>
		</c:forEach>
	</ol>
</body>
</html>
