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
	font-weight: 500;
	line-height: 1.5;
	margin: 1rem;
}

ol, ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

.role-item {
	background: #fff;
	padding: 1rem;
	border-radius: 12px;
	margin-bottom: 1rem;
	box-shadow: -1px 1px 8px #00000010;
}

.role-id {
	background: #0081ff1a;
	color: #0081ff;
	padding: 2px 6px;
	margin-right: 8px;
	border-radius: 6px;
}

.user-list {
	margin-top: 12px;
}

.user {
	font-weight: 400;
}
</style>
</head>
<body>
	<h2>Role list</h2>
	<ol>
		<c:forEach var="role" items="${roles}">
			<li class='role-item'><span class='role-id'> #${role.id}
			</span> <span class='role-name'> ${role.roleName} </span>
				<ul class=user-list>
					<c:forEach var="user" items="${role.user}">
						<li class='user'>${user}</li>
					</c:forEach>
				</ul></li>

		</c:forEach>
	</ol>
</body>
</html>