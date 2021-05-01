<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<h3>Welcome to Student Registration page</h3>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/addStudent"
		modelAttribute="student">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td><form:label path="emailId">EmailId</form:label></td>
				<td><form:input path="emailId" /></td>
				<td><form:errors path="emailId" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="emailId">Select Courses :</form:label></td>
				<td><form:select path="course">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="B.E" label="Bachelor Of Engg" />
						<form:option value="M.Tech" label="Master in Technology" />
						<form:option value="MBA" label="Master in Business Administrative" />
						<form:option value="PhD" label="PhD" />
						<form:options items="${courseList}" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender :</form:label></td>
				<td><form:label path="gender">Male</form:label> <form:radiobutton
						path="gender" value="Male" /> <form:label path="gender">Female</form:label>
					<form:radiobutton path="gender" value="Female" /></td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:label path="hobby">Hobby :</form:label></td>
				<td><form:label path="hobby">Cricket :</form:label> <form:checkbox
						path="hobby" value="cricket" /> <form:label path="hobby">Hockey :</form:label>
					<form:checkbox path="hobby" value="hockey" /> <form:label
						path="hobby">Volley-Ball :</form:label> <form:checkbox
						path="hobby" value="volleyball" /> <form:label path="hobby">Kabbadi :</form:label>
					<form:checkbox path="hobby" value="kabbadi" /></td>
			</tr>
			<tr>
				<form:hidden path="id" />
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>