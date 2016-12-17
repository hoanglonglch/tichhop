<%@ page import="java.util.*" %>	
<%@ page import="com.guru.model.New" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="container">
		<h2>${parentCate.parentName}</h2>

		<div class="table-responsive">
			<table class="table">
				<!-- sort list here -->
						<thead>
							<tr>
								<th>id new</th>
								<th>category</th>
								<th>view</th>
								<th>upload</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${approvalNew1}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.category.name}</td>
								<td><a href="${contextPath}/admin/new/${item.id}">view detail</a></td>
								<td><a href="${contextPath}/admin/upload/?id=${item.id}">upload</a></td>
							</tr>
							</c:forEach>
						</tbody>
			</table>
		</div>
</div>
