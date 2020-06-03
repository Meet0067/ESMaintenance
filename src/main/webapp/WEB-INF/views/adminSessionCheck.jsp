<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String str = (String) session.getAttribute("isValidAdmin");

		 if(str == null || !str.equals("true")) {
		
			 throw new RuntimeException("Someone is trying to get in admin pages without login!!!");
		
		} else {
			 
		}
	%>
</body>
</html>