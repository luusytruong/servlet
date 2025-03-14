<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${pageContext.request.contextPath }/week5/styles.css'>
</head>
<body>
	<form action='/servlet/post/update' method='post'>
		<h2>Update Post</h2>
		<label class='field-id'>
			<p>ID</p> <input type='text' name='id' value="${post.id }" readonly />
		</label>
		<label>
			<p>Title</p> <input type='text' name='title' value="${post.title }"/>
		</label>
		 <label>
			<p>Content</p> <textarea type='text' name='content' >${post.content }</textarea>
		</label> <label>
			<p>Location</p> <input type='text' name='location' value="${post.location }" />
		</label> <br />
		<input type='submit' value='Submit' />
	</form>
</body>
</html>