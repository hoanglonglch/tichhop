<%@ page import="java.util.*" %>	
<%@ page import="com.guru.model.New" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:forEach items="${parentCates}" var="parentCate">
<div class="container">
		<h2>${parentCate.parentName}</h2>

		<div class="table-responsive">
			<table class="table">
				
				<c:set var="listNews" value="${category.news}"></c:set>
				
				<!-- sort list here -->
					
						<thead>
							<tr>
								<th>category</th>
								<th>id new</th>
								<th>new title</th>
								<th>content</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${parentCate.categories}" var="category">
						<c:forEach items="${category.news}" var="new1">
							<tr>
								<td>${category.name}</td>
								<td>${new1.id}</td>
								<td>${new1.title}</td>
								<td><a href="${contextPath}/admin/new/${new1.id}">view detail</a></td>
							</tr>
					</c:forEach>
				</c:forEach>
						</tbody>
			</table>
		</div>
</div>
	</c:forEach>