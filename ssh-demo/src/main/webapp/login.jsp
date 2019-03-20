<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Signin Template · Bootstrap</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="Signin%20Template%20%C2%B7%20Bootstrap_files/bootstrap.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="Signin%20Template%20%C2%B7%20Bootstrap_files/signin.css"
	rel="stylesheet">
</head>
<body class="text-center">
	<form class="form-signin"
		action="${pageContext.request.contextPath }/loginSub">
		<img class="mb-4"
			src="Signin%20Template%20%C2%B7%20Bootstrap_files/bootstrap-solid.svg"
			alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Username</label> <input name="username"
			type="text" id="inputEmail" class="form-control"
			placeholder="Username" required="" autofocus=""> <label
			for="inputPassword" class="sr-only">Password</label> <input name="password"
			type="password" id="inputPassword" class="form-control"
			placeholder="Password" required="">
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted">© 2017-2019</p>
	</form>


	<div id="translate-man-app" class="content-3WfBL_0"
		style="background-color: rgb(255, 255, 255); display: none;">
		<div data-v-2868eb04="" class="outputBox-qe9A4_0">
			<div data-v-2868eb04="" class="outputBox-3oESn_0">
				<span data-v-2868eb04="" class="outputBox-13Ovx_0"></span>
				<!---->
			</div>
			<div data-v-2868eb04="" class="outputBox-1GLb__0">
				<!---->
				<div data-v-2868eb04="" class="outputBox-onVZH_0">
					<img src="Signin%20Template%20%C2%B7%20Bootstrap_files/sound.svg"
						class="icon-tprjJ_0">
				</div>
			</div>
			<div data-v-2868eb04="" class="outputBox-2sJgr_0"></div>
			<div data-v-2868eb04="" class="outputBox-17RAm_0"
				style="display: none;">
				<!---->
				<!---->
				<!---->
				<div data-v-2868eb04=""></div>
			</div>
		</div>
	</div>
</body>
</html>