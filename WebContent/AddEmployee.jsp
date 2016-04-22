<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
	<form action="AddEmployee.do" method="post">

		Add an employee <input name="firstName"
			placeholder="first name" /> <input name="lastName"
			placeholder="last name"/> 
			<input name="jobId"
			placeholder="job id" /> 
			<input name="departmentId"
			placeholder="department id" /> 
			
		</select> <input type="submit" name="submit" value="Add Employee" />

	</form>
</body>
</html>