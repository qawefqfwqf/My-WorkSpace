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
	<div>
		<s:debug></s:debug>
	</div>
	<div class="container">
		<div class="btn-group">
			<a type="button" class="btn btn-primary" href="add">添加</a> <a type="button"
				class="btn btn-primary">编辑</a> <a type="button"
				class="btn btn-primary">删除</a>
		</div>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>用户名</th>
					<th>密码</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.list">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="username" /></td>
						<td><s:property value="password" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>
