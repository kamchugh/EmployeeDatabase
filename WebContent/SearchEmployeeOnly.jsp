<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="EmployeeDatabase.css" />
<link href='https://fonts.googleapis.com/css?family=PT+Serif+Caption' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Just By Employee</title>
</head>
<body>
<header>
		<h1 class="orangeBorder">MoVo - HR</h1>
	</header>
	<div class="search">
	<form action="selectEmployee.do" method="get">
		<%-- Employee ID: <input name="id" value="${employee.id}" /> --%>
		
		
			Employee ID: <select
			name="firstname">
			<c:forEach items="${employees}" var="emp">
				<option value="${emp.id}" label="${emp.id}"></option>
			</c:forEach>
			</select> 
		
		First Name: <select
			name="firstname">
			<c:forEach items="${employees}" var="emp">
				<option value="${emp.firstName}" label="${emp.firstName}"></option>
			</c:forEach>
			</select> 
		
		
				Last Name: <select
			name="lastname">
			<c:forEach items="${employees}" var="emp">
				<option value="${emp.lastName}" label="${emp.lastName}"></option>
			</c:forEach>
			
		</select> 
		
		
			Job ID: <select
			name="lastname">
			<c:forEach items="${employees}" var="emp">
				<option value="${emp.jobId}" label="${emp.jobId}"></option>
			</c:forEach>
			
		</select> 
		
			
			Department: <select
			name="departmentId">
			<c:forEach items="${departments}" var="dept">
				<option value="${dept.id}" label="${dept.name}"
					<c:if test="${employee.departmentId == dept.id}"> selected
				</c:if>>
					${dept.name}</option>
			</c:forEach>
		</select> <input type="submit" name="submit" value="Find Employee" />


	</form>
	</div>
</body>
</html>