<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入el标识所需要的标签 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<form action="${pageContext.request.contextPath}/data/submit3"
			method="post">
			username:<input type="text" name="user.username" /> <br />
			password:<input type="text" name="user.password" /> <br /> <input
				type="submit" value="提交">
		</form>

		<form action="${pageContext.request.contextPath}/data/submit3_2"
			method="post">
			username:<input type="text" name="list[0].username" /> <br />
			password:<input type="text" name="list[0].password" /> <br /> <input
				type="submit" value="提交2">
		</form>

		<form action="${pageContext.request.contextPath}/data/submit3_3"
			method="post">
			username:<input type="text" name="map['user'].username" /> <br />
			password:<input type="text" name="map['user'].password" /> <br /> <input
				type="submit" value="提交3">
		</form>

	</div>

</body>
</html>