<%@page import="week5.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet'
	href='${pageContext.request.contextPath }/week5/styles.css'>
</head>
<body>
	<h2>Post List</h2>
	<a class='new' href="/servlet/post/create">new</a>
	<ul>
		<c:forEach var="post" items="${posts }">
			<li onclick="console.log(JSON.parse(${post}))">
				<p>${post.id }</p>
				<p>${post.title }</p>
				<p>${post.content }</p>
				<p>${post.location }</p>
				<div>
					<a href="/servlet/post/update?id=${post.id}&title=${post.title}&content=${post.content}&location=${post.location}">update</a>
					<a href="/servlet/post/delete?id=${post.id}">delete</a>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>