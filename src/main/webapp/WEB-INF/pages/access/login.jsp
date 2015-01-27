<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html lang="en">
<head>
<title>Sign in</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/login.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-1.9.1.js"></script>



<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/pages/header.jsp" />
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="sign.in" />
					</div>
					<div
						style="float: right; font-size: 80%; position: relative; top: -10px">
						<a href="#"><spring:message code="forgot.pass" /></a>
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form id="loginform" class="form-horizontal" role="form"
						action="j_spring_security_check" method="post">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" id="j_username"
								name="j_username" value=""
								placeholder=<spring:message code="email"/> autofocus>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" id="j_password"
								name="j_password" placeholder=<spring:message code="pass" />>
						</div>

						<c:if test="${not empty message}">
							<span class="message"><spring:message code="${message}" />
							</span>
						</c:if>
						<div class="input-group">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1"> <spring:message
										code="remember.me" />
								</label>
							</div>
						</div>


						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<button class="btn btn-success">
									<spring:message code="sign.in" />
								</button>
								<a id="btn-fblogin" href="#" class="btn btn-primary"><spring:message
										code="sign.in.fb" /></a>

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									<spring:message code="dont.have.acc" />
									<a href="registr"> <spring:message code="sign.up.here" />
									</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

