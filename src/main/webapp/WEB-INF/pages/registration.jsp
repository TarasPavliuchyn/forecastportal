<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

		<div id="signupbox" style="margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="sign.up" />
					</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						<a id="signinlink" href="login"><spring:message code="sign.in" /></a>
					</div>
				</div>
				<div class="panel-body">
					<form id="signupform" class="form-horizontal" role="form"
						commandName="newUser" action="registration" method="POST">

						<c:if test="${not empty message}">
							<div id="signupalert" class="alert alert-danger">
								<p>
									<spring:message code="${message}" />
								</p>
								<span></span>
							</div>
						</c:if>


						<div class="form-group">
							<label for="email" class="col-md-3 control-label"><spring:message
									code="email" /></label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="email"
									path="email" placeholder="<spring:message code="email"/>"
									required autofocus>
							</div>
						</div>

						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label"><spring:message
									code="fname" /></label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="fname"
									path="fname" placeholder="<spring:message code="fname"/>"
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label"><spring:message
									code="lname" /></label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="lname"
									path="lname" placeholder="<spring:message code="lname"/>"
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label"><spring:message
									code="pass" /></label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="password"
									id="password1" path="password"
									placeholder="<spring:message code="pass"/>" required>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-3 control-label"><spring:message
									code="confirm.pass" /></label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="passwd"
									id="password2"
									placeholder="<spring:message code="confirm.pass"/>" required>
							</div>
						</div>
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="submit" class="btn btn-info">
									<i class="icon-hand-right"></i> &nbsp
									<spring:message code="sign.up" />
								</button>
								<span style="margin-left: 8px;"><spring:message code="or" /></span>
							</div>
						</div>

						<div style="border-top: 1px solid #999; padding-top: 20px"
							class="form-group">

							<div class="col-md-offset-3 col-md-9">
								<button id="btn-fbsignup" type="button" class="btn btn-primary">
									<i class="icon-facebook"></i>  
									<spring:message code="sign.up.fb" />
								</button>
							</div>

						</div>
					</form>
					<script type="text/javascript">
						window.onload = function() {
							document.getElementById("password1").onchange = validatePassword;
							document.getElementById("password2").onchange = validatePassword;
						}
						function validatePassword() {
							var pass2 = document.getElementById("password2").value;
							var pass1 = document.getElementById("password1").value;
							if (pass1 != pass2)
								document.getElementById("password2")
										.setCustomValidity(
												"Passwords Don't Match");
							else
								document.getElementById("password2")
										.setCustomValidity('');
							//empty string means no validation error
						}
					</script>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

