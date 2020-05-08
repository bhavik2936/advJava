<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
	<style>
		.error {
			color: red;
		}
	</style>
</head>
<body>
	<s:form action="dashboard" method="post" modelAttribute="userBean" >
		Email: <s:input path="email" /> <s:errors path="email" cssClass="error"></s:errors> <br>
		Password: <s:password path="password" /> <s:errors path="password" cssClass="error"></s:errors> <br>
		<input type="submit" value="Sign Up">
	</s:form>
</body>
</html>