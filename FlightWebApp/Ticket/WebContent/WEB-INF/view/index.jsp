<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:h="http://java.sun.com/jsf/html">
      
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flights</title>
</head>

<body>
<p>
      Hello! You are logged as: <b>
     <c:out value="${pageContext.request.remoteUser}"/></b>
    </p>
  <div class="container" align="center">
 
	        <h1>Flight List</h1>
	        <h3><a href="admin/newFlight">New Flight</a></h3>
    <form>
	        <table border="1">
	        	<th>No</th>
	        	<th>Airplane Type</th>
	        	<th>Departure Date</th>
	        	<th>Arrival Date</th>
	        	<th>Departure City</th>
	        	<th>Departure Hour</th>
	        	<th>Arrival City</th>
	        	<th>Arrival Hour</th>
	        	<th>Action</th>
	        				
				<c:forEach var="flight" items="${listFlight}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${flight.airplaneType}</td>					
					<td>${flight.departureDate}</td>
					<td>${flight.arrivalDate}</td>
					<td>${flight.departureCity}</td>
					<td>${flight.departureHour}</td>
					<td>${flight.arrivalCity}</td>
					<td>${flight.arrivalHour}</td>
					
					<td>				
						<a href="admin/editFlight?idFlight=${flight.idFlight}">Edit</a>					
						<a href="admin/deleteFlight?idFlight=${flight.idFlight}">Delete</a>
					
					</td>
					
				</tr>
        	</c:forEach>      		        							        	
			</table>	
		</form> 
		
		
		
		
    <c:url var="logoutUrl" value="/logout"/>
    <form class="form-inline" action="${logoutUrl}" method="post">
      <input type="submit" value="Log out" />
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
  </div>
</body>


</html>