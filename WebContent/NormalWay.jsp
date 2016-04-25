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
<title> Search Database </title>
</head>
<body>
	<header>
	<h1 class = "orangeBorder"> MoVo - HR </h1>
	</header>
	<div id = "purpleText">
		<h1> Search the MoVo employee database </h1>
		<h2> Pick a search option and it will appear below. </h2>
		<h3>[ These are your available tables ] </h3>
	</div>
	<div class= "container2">
		<div class = "box" "box1">
			<h4> Employees </h4>
			<p> Available search fields: id, firstname, middlename, lastname, gender, email, 
				extension, hiredate, salary, department_id, job_id, address, city, state, 
				zipcode </p>

	</div>
		<div class = "box" "box2">
			<h4> Departments </h4>
			<p> Available search fields: id, name, manager_id, location_id </p>
			
	</div>
	<div class = "box" "box3">
		<h4> Assignments </h4>
			<p> Available search fields: id, name, start_date, end_date, employee_id, project_id </p>
			
	</div>
</div>
<div class = "container2">
		
		<div class = "box" "box4">
			<h4> Jobs </h4>
			<p> Available search fields: id, name, minimum_salary, maximum_salary </p>
			
	</div>
		<div class = "box" "box5">
			<h4> Locations </h4>
			<p> Available search fields: id, square_footage, street_address, city, state, zipcode </p>
			
	</div>
		<div class = "box" "box6">

			<h4> Projects </h4>
			<p> id, name, start_date, end_date, project_parent_id </p>
			
	</div>
</div>
<div id = "purpleText">
		<h3>[ These are your available search options ] </h3>
	</div>
	<div class= "container2">
		<div class = "search" "box1">
			<h4> Find Anything in Any Table </h4>
			<p> <form action="selectEmployee.do" method="GET">
				<br> Field (firstname, lastname, etc) <input
					style="width: 75%;" type="text" name="getField"
					placeholder="getField"><br> Table <input
					style="width: 200px;" type="text" name="databaseName"
					placeholder="databaseName"><br> EQUAL TO <input
					style="width: 200px;" type="text" name="match" placeholder="match"><br>
				<input type="submit" name="submit" value="submit" />
			</form> </p>

	</div>
		<div class = "search" "box2">
			<h4> Update by Employee ID # </h4>
			<p> <form action="GetEmployeeById.do" method="GET">
					Update by Employee Number<input style="width: 300px;" type="text"
						name="id" placeholder="employeeNumber"><br> <input type="submit"
						name="submit" value="submit" />
				</form> </p>
			
	</div>
	<div class = "search" "box3">
		<h4> Remove by Employee ID # </h4>
			<p> Remove something by ID (employee, department, etc)
				<form action="deleteByID.do" method="GET">
					<br> Database <input style="width: 200px;" type="text"
						name="databaseName" placeholder="databaseName"><br>
					ID # <input style="width: 200px;" type="text" name="id"
						placeholder="id"><br> <input type="submit"
						name="submit" value="submit" /> </p>
			
	</div>
</div>
<div class = "container2">
		<div class = "search" "box4">
			
			<h4><a href = "GoToAddEmployeePage.do"> Add new employee  </a> </h4>
			
	</div>
		<div class = "search" "box5">
			<h4> <a href="searchEmployees.do">Search just by
						employee (this does not work, but was a personal stretch goal/ exploration)</a> </h4>
			
	</div>
</div>
<div id = "purpleText">
		<h3>[ Your search results ] </h3>
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
							<td>${numberDeleted} row(s)updated!You deleted all instances of
								ID ${DeletedId} found in the ${DeletedTable} table</td>
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