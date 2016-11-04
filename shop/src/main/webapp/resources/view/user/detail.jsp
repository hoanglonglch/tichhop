<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="column-two-third single">
	<h1>${newObj.title}</h1>
	
	<p>${newObj.content1}</p>
	<img src="${contextPath}/resources/images/${newObj.image1}" width="620" height="372" alt="..."
		class="img-rounded">

	<h6 class="title">${newObj.imageTitle1}</h6>

	<span class="meta">26 May, 2013. \\ <a href="#">${newObj.category.name}</a>
		\\
	</span>
	
	<p>${newObj.content2}</p>
	<img src="${contextPath}/resources/images/${newObj.image2}" width="620" height="372" alt="..."
		class="img-rounded">

	<h6 class="title">${newObj.imageTitle2}</h6>

	<span class="meta">26 May, 2013. \\ <a href="#">${newObj.category.name}</a>
		\\
	</span>

	

	
	
	<ul class="sharebox">
		<li><a href="#"><span class="twitter">Tweet</span></a></li>
		<li><a href="#"><span class="pinterest">Pin it</span></a></li>
		<li><a href="#"><span class="facebook">Like</span></a></li>
	</ul>
</div>