<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee</title>
</head>
<body>
	<form action="UpdateEmployee.do" method="post">

		Employee ID: ${employee.id} <input name="firstName"
			value="${employee.firstName}" />
			<input name="id" value ="${employee.id}" />
			 <input name="lastName"
			value="${employee.lastName}" /> <input name="jobId"
			value="${employee.departmentId}" /> <select name="departmentId">
			<c:forEach items="${departments}" var="dept">
				<option value="${dept.id}" label="${dept.name}" <c:if test="${employee.departmentId == dept.id}"> selected
				</c:if>>
					${dept.name}</option>
			</c:forEach>
		</select> <input type="submit" name="submit" value="Update Employee" />

	</form>
</body>
</html>