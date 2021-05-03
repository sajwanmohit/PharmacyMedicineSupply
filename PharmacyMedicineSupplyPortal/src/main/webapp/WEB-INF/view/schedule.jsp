
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container-fluid">
		<h1 align="center" class="mb-5">Schedule Appointment</h1>
		<div class="row h-30 d-flex justify-content-center p-10">
			<form:form action="/schedule" method="post"
				modelAttribute="startDate">
				<div class="form-row mb-3">
					<div class="col">
						<form:label for="date" path="date" class="form-control-lg">Schedule Start Date</form:label>
					</div>
					<div class="col">
						<form:input type="date" id="date" name="date"
							class="form-control form-control-lg" path="date"
							required="required" />

					</div>
				</div>
				<div class="form-row d-flex justify-content-center p-10">
					<input type="submit" class="btn btn-dark" value="Submit" />
				</div>
			</form:form>
		</div>

		<div class="row d-flex justify-content-center p-10 mt-3">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Representative Name</th>
						<th scope="col">Doctor Name</th>
						<th scope="col">Ailment</th>
						<th scope="col">Medicine</th>
						<th scope="col">Slot</th>
						<th scope="col">Date</th>
						<th scope="col">Doctor Contact</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="schedule" items="${scheduleList}">
						<tr>
								<td><c:out value="${schedule.repName}"></c:out></td>
								<td><c:out value="${schedule.doctorName}"></c:out></td>
								<td><c:out value="${schedule.treatingAilment}"></c:out></td>
								<td><c:out value="${schedule.medicine}"></c:out></td>
								<td><c:out value="${schedule.slot}"></c:out></td>
								<td><c:out value="${schedule.date}"></c:out></td>
								<td><c:out value="${schedule.doctorContact}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>


	<%@ include file="common/footer.jspf"%>