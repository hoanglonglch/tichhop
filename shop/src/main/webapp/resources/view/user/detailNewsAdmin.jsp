<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="column-two-third single">
	<h1>${newObj.title}</h1>
	
	<p>${newObj.content1}</p>
	
	<span class="meta">26 May, 2013. \\ <a href="#">${newObj.category.name}</a>
		\\
	</span>
	
</div>