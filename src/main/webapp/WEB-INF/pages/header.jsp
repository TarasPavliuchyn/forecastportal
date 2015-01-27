<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>'
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Forecast Portal</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="resources/bootstrap/css/styles.css" rel="stylesheet">
</head>
<body>
	<!-- begin template -->
	<div class="navbar navbar-custom navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">Forecast Portal</a> <a
				class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">  <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
<!-- 				<li class="active"><a href="#">Home</a></li> -->


				<security:authorize access="isAnonymous()">
					<li><a href="login">Login</a></li>
					<li><a href="registr">Registration</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href=""><span><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span></a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href="logout">Logout</a></li>
				</security:authorize>

				<li><a href="?lang=en">en</a></li>
				<li><a href="?lang=ua">ua</a></li>
				<li>&nbsp;</li>
			</ul>
			<form class="navbar-form">
				<div class="form-group" style="display: inline;">
					<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								<span class="glyphicon glyphicon-chevron-down"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">Category 1</a></li>
								<li><a href="#">Category 2</a></li>
								<li><a href="#">Category 3</a></li>
								<li><a href="#">Category 4</a></li>
								<li><a href="#">Category 5</a></li>
							</ul>
						</div>
						<input type="text" class="form-control"
							placeholder="What are searching for?"> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-search"></span> </span>
					</div>
				</div>
			</form>
		</div>
	</div>

	
		

		<!-- script references -->
		<script
			src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script
			src="http://maps.googleapis.com/maps/api/js?sensor=false&extension=.js&output=embed"></script>
		<script src="resources/bootstrap/js/scripts.js"></script>
</body>
</html>