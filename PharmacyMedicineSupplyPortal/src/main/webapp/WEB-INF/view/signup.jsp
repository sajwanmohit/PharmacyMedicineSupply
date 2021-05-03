

<%@ include file="common/header.jspf"%>
<%@ include file="common/signupnav.jspf"%>

<div class="container">
	<h2 align="center">Sign Up</h2>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->


			<!-- Signup Form -->
			<form:form action="/signup" method="post" modelAttribute="login"
				class="mt-3">
				<div class="form-group">
					<form:label path="username">Name</form:label>
					<form:input path="username" class="form-control" minlength="4" maxlength="14"/>
				</div>

				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:password path="password" class="form-control" minlength="5" maxlength="15" />
				</div>

				<input type="submit" value="Signup" class="btn btn-success mr-2" />
				<input type="reset" value="Clear" class="btn btn-danger" />
			</form:form>

		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>