<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${pageContext.request.contextPath }/week5/styles.css'>
</head>
<body>
	<form action='/servlet/post/create' method='post' accept-charset="UTF-8">
		<h2>New Post</h2>
		<label>
			<p>Title</p> <input type='text' name='title' />
		</label> <label>
			<p>Content</p> <textarea type='text' name='content'></textarea>
		</label> <label>
			<p>Location</p> <input type='text' name='location' />
		</label> <br />
		<input type='submit' value='Publish' />
	</form>
</body>
</html>