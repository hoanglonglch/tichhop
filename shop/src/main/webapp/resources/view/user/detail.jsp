<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="column-two-third single">
	${contextPath}
	<c:out value="${contextPath}"></c:out>
	<h1>${newObj.title}</h1>
	
	<p>${newObj.content1}</p>
	
	<span class="meta">26 May, 2013. \\ <a href="#">${newObj.category.name}</a>
		\\
	</span>
	

	

	
	
	<ul class="sharebox">
		<li><a href="#"><span class="twitter">Tweet</span></a></li>
		<li><a href="#"><span class="pinterest">Pin it</span></a></li>
		<li><a href="#"><span class="facebook">Like</span></a></li>
	</ul>
</div>