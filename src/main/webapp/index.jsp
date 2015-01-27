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
	<jsp:include page="/WEB-INF/pages/header.jsp" />

	<div id="map-canvas"></div>
	<div class="container-fluid" id="main">
		<div class="row">
			<div class="col-xs-8" id="left">
			<img
					src="${pageContext.request.contextPath}/img/logo.jpg"/>

				<h2>Forecast Portal Demo</h2>
				

				<!-- item list -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="">Item heading</a>
					</div>
				</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis
					pharetra varius quam sit amet vulputate. Quisque mauris augue,
					molestie tincidunt condimentum vitae, gravida a libero. Aenean sit
					amet felis dolor, in sagittis nisi. Sed ac orci quis tortor
					imperdiet venenatis. Duis elementum auctor accumsan. Aliquam in
					felis sit amet augue.</p>

				<hr>

				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="">Item heading</a>
					</div>
				</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis
					pharetra varius quam sit amet vulputate. Quisque mauris augue,
					molestie tincidunt condimentum vitae, gravida a libero. Aenean sit
					amet felis dolor, in sagittis nisi. Sed ac orci quis tortor
					imperdiet venenatis. Duis elementum auctor accumsan. Aliquam in
					felis sit amet augue.</p>

				<hr>

				

			</div>
		</div>
		<!-- end template -->

		<!-- script references -->
		<script
			src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script
			src="http://maps.googleapis.com/maps/api/js?sensor=false&extension=.js&output=embed"></script>
		<script src="resources/bootstrap/js/scripts.js"></script>
</body>
</html>