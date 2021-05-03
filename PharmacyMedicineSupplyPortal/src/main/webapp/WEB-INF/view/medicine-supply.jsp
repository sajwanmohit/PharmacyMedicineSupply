<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	
	<div class="container">
    <h1 class="mt-3 display-4">Welcome ${login.getUsername()}</h1>
	</div>
	<hr/>
	
	
	<div class="container">
		<div class="table-responsive">

			<table class="table ">
				
				
				
				<tr>
				<th>Medicine Name</th>
				<th>Demand</th>
				</tr>
				
   					<c:forEach items="${stocks}" var="stock">
   					<tr>
   					
   					<td>
   					<c:out value="${stock.medicineName}"/>  
   					</td>
   					<td>
		    <!-- Add Form -->
    <form action="/add/${stock.medicineName}" method="post"  >
            <input type="text"  name="demandCount" />
        <input type="submit" value="Add" class="btn btn-success mr-2"/>
    </form>
   					</td>
				</tr>	
				</c:forEach>	
				
				<tr> <td><div class="col" ><a href="<c:url value="/supply"></c:url>"
                                    class="btn btn-primary float-right " id="btn"><i
                                        class="material-icons"></i>Supply Medicine</a></div></td>	<td> ${param.msg} </td>
                </tr>	
				</tbody>
			</table>
		</div>
	</div>
	<hr/>
	
	
	<div>
	<h2 align="center">List of Medicines Added</h2>
	
	<table align="center" border="1px">
	<tbody>
	<tr>
	<th>
	Medicine
	</th>
	<th>
	Demand
	</th>
	</tr>
	<c:forEach var="entry" items="${demandList}">
	<tr>
	<td>
  <c:out value="${entry.key}"/>
  </td>
  <td>
  <c:out value="${entry.value}"/>
  </td>
  </tr>
</c:forEach>
		</tbody>
	</table>
	</div>


	<div>
	<br/><br/>
	</div>
	
<%@ include file="common/footer.jspf"%>

