<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="EmployeeDatabase.css" />
<link href='https://fonts.googleapis.com/css?family=PT+Serif+Caption'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee</title>
</head>
<body>
	<header>
	<h1 class="orangeBorder">MoVo - HR</h1>
	</header>
	<div class="search">
		<c:choose>
			<c:when test="${! empty(employee.firstName)}">
				<form action="UpdateEmployee.do" method="post">

					First Name <input name="firstName" value="${employee.firstName}" />
					Last Name <input name="lastName" value="${employee.lastName}" />
					Employee ID <input name="id" value="${employee.id}" /> Job <select
						name="jobId">
						<c:forEach items="${jobs}" var="job">
							<option value="${job.id}" label="${job.name}"
								<c:if test="${employee.jobId == job.id}"> selected
				</c:if>>
								${job.name}</option>
						</c:forEach>
					</select> Department Name <select name="departmentId">
						<c:forEach items="${departments}" var="dept">
							<option value="${dept.id}" label="${dept.name}"
								<c:if test="${employee.departmentId == dept.id}"> selected
				</c:if>>
								${dept.name}</option>
						</c:forEach>
					</select> <input type="submit" name="submit" value="Update Employee" />


				</form>
			</c:when>
			<c:when test="${ empty(employee.firstName)}">
	<h4 id="purpleText"> There's no employee by that id.</h4>
	 <a href="NormalWay.jsp">  Go back to the main page  </a>
	</c:when>
		</c:choose>


	</div>
</body>
</html>