<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../resources/core/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr id="listShopView">
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roles}" var="customer">
					<tr>
						<td>${customer.getName()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>