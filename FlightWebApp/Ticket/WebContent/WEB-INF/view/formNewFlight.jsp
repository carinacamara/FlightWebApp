<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Flight</title>
</head>
<body>
	<div align="center">
		<h1>New Flight</h1>
		<form:form action="saveNewFlight" method="post" modelAttribute="flight">
		
		<table>
			<form:hidden path="idFlight"/>

			<tr>
				<td>Airplane Type:</td>
				<td><form:input path="airplaneType" /><form:errors path="airplaneType" ></form:errors></td>
			</tr>
			<tr>
				<td>Departure City:</td>
				<td><form:input path="departureCity" /><form:errors path="departureCity" ></form:errors></td>
			</tr>
			<tr>
				<td>Arrival City:</td>
				<td><form:input path="arrivalCity" /><form:errors path="arrivalCity" ></form:errors></td>
			</tr>
			<tr>
				<td>Departure Date:</td>
				<td><form:input path="departureDate" />
				</td> 
				
			</tr>
			<tr>
				<td>Arrival Date:</td>
				<td><form:input path="arrivalDate" />
				</td> 
				
			</tr>
			<tr>
				<td>Departure Hour:</td>
				<td><form:input path="departureHour" /> <form:errors path="departureHour" ></form:errors>
				</td> 
				
			</tr>
			<tr>
				<td>Arrival Hour:</td>
				<td><form:input path="arrivalHour" /> <form:errors path="arrivalHour" ></form:errors>
				</td> 
				
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
		<form action="/Ticket/listFlight">
        <input type="submit" value="Cancel"/>
        </form>
		<form action="/Ticket/login?logout">
        <input type="submit" value="Logout"/>
    </form>
	</div>
</body>
</html>