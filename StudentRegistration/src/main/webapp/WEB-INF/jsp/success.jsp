<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Records</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Student List</h1>

		<p>
			<a href="${pageContext.request.contextPath}/registration"><b>ADD
					STUDENT</b></a>
		</p>
		<table class="table table-striped table-bordered">
			<tr class="thead-dark">
				<th>Id</th>
				<th>Student-Name</th>
				<th>City</th>
				<th>Email</th>
				<th>Course</th>
				<th>Gender</th>
				<th>Hobbies</th>
				<th>Action</th>

			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.city}</td>
					<td>${student.emailId}</td>
					<td>${student.course}</td>
					<td>${student.gender}</td>
					<td><c:forEach items="${student.hobby}" var="hobby">
							${hobby}
						</c:forEach></td>

					<td><a
						href="${pageContext.request.contextPath}/updateStudent?id=${student.id}">Edit</a>
						|| <a
						href="${pageContext.request.contextPath}/deleteStudent?id=${student.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>