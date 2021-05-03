<%@ include file="common/header.jspf"%>
<%@ include file="common/loginnav.jspf"%>

<div class="container">
	<h2 align="center">Login</h2>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->


			<!-- Login Form -->
			<form:form action="/login" method="post" modelAttribute="login"
				class="mt-3">
				<div class="form-group">
					<form:label path="username">Name</form:label>
					<form:input path="username" class="form-control" />
				</div>

				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:password path="password" class="form-control" />
				</div>
				<p>${message}</p>

				<input type="submit" value="Login" class="btn btn-success mr-2" />
				<input type="reset" value="Clear" class="btn btn-danger" />
			</form:form>

		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>

