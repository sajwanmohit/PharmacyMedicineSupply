<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Supply Available</h1>
    <h1 class="mt-3 display-4">Welcome ${login.getUsername()}</h1>
	</div>
	<hr/>
	
	
	<div class="container">
		<div class="table-responsive">

			<table class="table ">
				
				
				
				<tr>
				<th>Pharmacy Name</th>
				<th>Medicine Name</th>
				<th>Supply Count</th>
				</tr>
				
				<c:forEach items="${medicineSupply}" var="supply">
   					<tr>
   					
   					<td>
   					<c:out value="${supply.pharmacyName}"/>  
   					</td>
   					<td>
   					<c:out value="${supply.medicineName}"/>  
   					</td>
   					<td>
   					<c:out value="${supply.supplyCount}"/>  
   					</td>
				</tr>	
				</c:forEach>	
				
   								</tbody>
			</table>
		</div>
	</div>
	<hr/>
	
	








<%@ include file="common/footer.jspf"%>