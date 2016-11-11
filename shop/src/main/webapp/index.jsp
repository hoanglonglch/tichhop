<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder" %>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ckfinder/ckfinder.js"></script>
</head>
<body>
	<h2>Hello World!</h2>
	<%-- <c:redirect url="/home"/> --%>
	
	<input id="editor1"/>
	<ckeditor:replace replace="editor1" basePath="/ckeditor/" />
	<ckfinder:setupCKEditor basePath="/shop/resources/ckfinder" />
</body>
</html>
