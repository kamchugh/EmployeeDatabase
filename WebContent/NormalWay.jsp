<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="EmployeeDatabase.css" />
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Database</title>
</head>
<body>
	<header class="header"> Search the Employee Database </header>
	<div class="container">
		<div class=box box1>
			Find an employee by field
			<form action="selectEmployee.do" method="GET">
				<br> Field (firstname, lastname, etc) <input
					style="width: 200px;" type="text" name="getField"
					placeholder="getField"><br> Database <input
					style="width: 200px;" type="text" name="databaseName"
					placeholder="databaseName"><br> EQUAL TO <input
					style="width: 200px;" type="text" name="match" placeholder="match"><br>
				<input type="submit" name="submit" value="submit" />
			</form>
		</div>
		<div class=box box2>
			<form action="GetEmployeeById.do" method="GET">
				Update by Employee Number<input style="width: 300px;" type="text"
					name="id" value=" "><br> <input type="submit"
					name="submit" value="submit" />
			</form>
		</div>
		<div class=box box3>
			Remove something by ID (employee, department, etc)
			<form action="deleteByID.do" method="GET">
				<br> Database <input style="width: 200px;" type="text"
					name="databaseName" placeholder="databaseName"><br> ID
				# <input style="width: 200px;" type="text" name="id"
					placeholder="id"><br> <input type="submit"
					name="submit" value="submit" />
			</form>
		</div>
		<div class=box box3>
			<a href = "AddEmployee.jsp"><button> Add new employee </button> </a>
			
		</div>
	</div>
	<div class="queryContainer">

		<c:choose>
			<c:when test="${! empty(getEmployeeResult)}">
				<table class="queryTable">
					<c:forEach var="queryResult1" items="${getEmployeeResult}">
						<tr>
							<c:forEach var="queryResult2" items="${queryResult1}">
								<td>${queryResult2}<br> <br> <br>
							</c:forEach>

							<td></td>
						</tr>
					</c:forEach>
				</table>

			</c:when>
			<c:when test="${! empty(numberDeleted)}">
				<table class="queryTable">
					<tr>
						<td>${numberDeleted}row(s) updated! You deleted all instances
							of ID ${DeletedId} found in the ${DeletedTable} table</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${! empty(nameUpdated)}">

				<table class="queryTable">
					<tr>
						<td>${nameUpdated} has been updated!</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${! empty(nameAdded)}">

				<table class="queryTable">
					<tr>
						<td>${nameAdded} has been added!</td>
					</tr>
				</table>
			</c:when>
		</c:choose>

	</div>
</body>
</html>