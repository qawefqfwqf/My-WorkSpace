<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入el标识所需要的标签 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>

	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" varStatus="i" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.address}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
		<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.list">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="name"/></td>
						<td><s:property value="address"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

	</div>

</body>
</html>