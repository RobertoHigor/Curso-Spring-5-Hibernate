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
		
		<br>
		
		Favorite Language:
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		Python <form:radiobutton path="favoriteLanguage" value="Python"/>
		
		<br>
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
		
		<input type="submit" value="Submit" />
		
	</form:form>
</body>

</html>