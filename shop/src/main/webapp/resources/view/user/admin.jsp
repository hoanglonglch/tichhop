<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Message : ${message}

Author : ${author}<br>
 
<%--  <c:url value="/j_spring_security_logout" var="logout"></c:url>
 <a href="${logout}">logout</a> --%>
 
 <a href="<c:url value="/logout" />" > Logout</a>


</body>
</html>