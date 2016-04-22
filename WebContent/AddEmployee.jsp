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
<title> Add Employee </title>
</head>
<body>
<header>
		<h1 class="orangeBorder">MoVo - HR</h1>
	</header>
	<div class = "search">
	<form action="AddEmployee.do" method="post">
		Add an employee 
		 <input name="firstName"
			placeholder="first name" />  <input name="lastName"
			placeholder="last name"/> 
			Job <select name="jobId">
			<c:forEach items="${jobs}" var="job">
				<option value="${job.id}" label="${job.name}" <c:if test="${employee.jobId == job.id}"> selected
				</c:if>>
					${job.name}</option>
			</c:forEach>
		</select> 
			<!-- <input name="departmentId"
			placeholder="department id" />  -->
			Department <select name="departmentId">
			<c:forEach items="${departments}" var="dept">
				<option value="${dept.id}" label="${dept.name}" ></option>
			</c:forEach> </select>	
		</select> <input type="submit" name="submit" value="Add Employee" />
	</form>
	</div>
</body>
</html>