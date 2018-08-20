<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Please find the details below</h1>
	<table>	
		<tr>
			<td>EMPLOYEE_ID</td>
			<td>FIRST_NAME</td>
			<td>LAST_NAME</td>
			<td>EMAIL</td>
			<td>PHONE_NUMBER</td>
			<td>HIRE_DATE</td>
			<td>JOB_ID</td>
			<td>SALARY</td>
			<td>COMMISSION_PCT</td>
			<td>MANAGER_ID</td>
			<td>DEPARTMENT_ID</td>
		</tr>	
	<c:forEach items="${emplist1}" var="emp">
		<tr>
			<td><c:out value="${emp.getEmployee_id()}" /></td>
			<td><c:out value="${emp.getFirst_name()}" /></td>
			<td><c:out value="${emp.getLast_name()}" /></td>
			<td><c:out value="${emp.getEmail()}" /></td>
			<td><c:out value="${emp.getPhone_number()}" /></td>
			<td><c:out value="${emp.getHire_date()}" /></td>
			<td><c:out value="${emp.getJob_id()}" /></td>
			<td><c:out value="${emp.getSalary()}" /></td>
			<td><c:out value="${emp.getCommission_pct()}" /></td>
			<td><c:out value="${emp.getManager_id()}" /></td>
			<td><c:out value="${emp.getDepartment_id()}" /></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>