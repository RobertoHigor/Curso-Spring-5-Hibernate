<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName" />
		<br>
		Last Name: <form:input path="lastName" />
		<br>
		
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		
		<br>
		
		<input type="submit" value="Submit" />
		
	</form:form>
</body>

</html>