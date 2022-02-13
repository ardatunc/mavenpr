<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead>
		<tr style="font-weight: bold;" bgcolor="grey">
			<td>Student ID</td>
			<td>Student Name</td>
			<td>Student LastName </td>
		</tr>
	</thead>
	<c:forEach items="${students}" var="student">
		<tr bgcolor = "${status.index % 2 == 0 ? 'lightblue' : 'lightgreen' }">
			<td>${student.id}</td>
			<td>${student.firstName}</td>
			<td>${student.lastName}</td>
		
		</tr>
		 
	</c:forEach>
	
</table>

</body>
</html>