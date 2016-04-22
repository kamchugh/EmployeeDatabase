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
<title>SQL Practice</title>
</head>
<body>
	<header>
	<h1 class = "orangeBorder"> MoVo - HR </h1>
	</header>
	<div class="container">
		<div class=search box1>
			<form action="query.do" method="GET">
				<h4> Query </h4> <input style="width: 300px;" type="text" name="query"
					value="SELECT"><br> <input type="submit" name="submit"
					value="submit" />
			</form>
		</div>
		<div class=search box2>
			<form action="query.do" method="GET">
				<h4> Update </h4><input style="width: 300px;" type="text" name="query"
					value="UPDATE"><br> <input type="submit" name="submit"
					value="submit" />
			</form>
		</div>
		<div class=search box3>
			<form action="query.do" method="GET">
				<h4> Remove </h4> <input style="width: 300px;" type="text" name="query"
					value="DELETE FROM"><br> <input type="submit"
					name="update" value="submit" />
			</form>
		</div>
	</div>
	<div class="queryContainer">

		<c:choose>
			<c:when test="${! empty(rowResults)}">
				<table class="queryTable">
					<c:forEach var="queryResult1" items="${rowResults}">
						<tr>
							<c:forEach var="queryResult2" items="${queryResult1}">
								<td>${queryResult2}<br> <br> <br>
							</c:forEach>

							<td></td>
						</tr>
					</c:forEach>
				</table>

			</c:when>
			<c:when test="${! empty(numberUpdated)}">
				<table class="queryTable">
					<tr>
						<td>${numberUpdated} row(s) updated!</td>
					</tr>
				</table>
			</c:when>
		</c:choose>

	</div>
</body>
</html>