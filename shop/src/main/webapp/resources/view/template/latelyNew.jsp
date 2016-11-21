
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- Latety News -->
<div class="column-one-third">
	<h5 class="line">
		<span>Popular News.</span>
	</h5>
	<div class="outertight">
		<ul class="block">
			<c:forEach items="${latetyNew}" var="item">
				<li><a href="${contextPath}/new/${item.id}"><img
						src="${contextPath}/resources/images/${item.image1}"
						alt="MyPassion" class="alignleft" width="160" height="86" /></a>
					<p>
						<span>${item.title}</span> <a href="#">${item.splitContent2}</a>
					</p></li>
			</c:forEach>
		</ul>
	</div>

</div>
<!-- /Popular News -->

<!-- Hot News -->
<div class="column-one-third">
	<h5 class="line">
		<span>Hot News.</span>
	</h5>
	<div class="outertight m-r-no">
		<ul class="block">
		<c:forEach items="${hotNew}" var="item">
			<li><a href="${contextPath}/new/${item.id}"><img
						src="${contextPath}/resources/images/${item.image1}"
						alt="MyPassion" class="alignleft" width="160" height="86" /></a>
					<p>
						<span>${item.title}</span> <a href="#">${item.splitContent2}</a>
					</p></li>
		</c:forEach>
		</ul>
	</div>

</div>
<!-- /Hot News -->