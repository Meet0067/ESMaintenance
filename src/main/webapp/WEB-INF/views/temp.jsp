<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form method="get" action="saveusertemp" commandName="tempuser">
	
	Email:<s:input  path="email" /><s:errors path="Email" cssClass="errors"></s:errors><br />
	password:<s:input path="password"/><s:errors path="password" cssClass="errors"> </s:errors>
	<input type="submit"/>login
	</s:form>
</body>
</html>