<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入el标识所需要的标签 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 引入struts2所需要的标签 -->
<%@taglib prefix="s" uri="/struts-tags"%>
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
<style type="text/css">
div {
	display: block;
}
</style>
</head>
<body>
	<s:debug></s:debug>

	<s:property value="hello" />

	<s:property value="user.username" />
	<s:property value="user.password" />

	<s:property value="list[0].username" />
	<s:property value="list[1].password" />


	<s:iterator value="list">
		<div>
			<s:property value="username" />
			<s:property value="password" />
		</div>
	</s:iterator>

	<div>
		<s:property value="setTest" />
	</div>

	<div>
		<s:property value="[0].top" />
	</div>

</body>
</html>
