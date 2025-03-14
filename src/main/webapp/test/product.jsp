<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: #f3f5f6;
	font-family: Inter;
}

ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

li {
	padding: 1rem;
	border-radius: 12px;
	box-shadow: -1px 1px 8px #0000001a;
	margin-bottom: 1rem; &
	p: first-child{ 
color: #0081ff;
}
}
</style>
</head>
<body>
	<h2>List Product</h2>
	<ul>
		<c:forEach var="prd" items="${newProducts }">
			<li class='item'>
				<p>#${prd.id }</p>
				<p>${prd.name }${prd.price }</p>
			</li>
		</c:forEach>
	</ul>
</body>
</html>