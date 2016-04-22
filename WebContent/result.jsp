<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Result</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty(rowResults)}">
			<table id="query">
				 <c:forEach var="queryResult1" items="${rowResults}">
					<tr>
						<c:forEach var="queryResult2" items="${queryResult1}">
							<td>${queryResult2} <br> <br> <br>
						</c:forEach>
						
						<td> </td>
					</tr>
				</c:forEach> 
			</table>
		</c:when>
		<c:otherwise> 
${numberUpdated} row(s) updated!
</c:otherwise>
	</c:choose>
</body>
</html>