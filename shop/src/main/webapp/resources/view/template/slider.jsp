<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<section id="slider">
	<div class="container">
		<div class="main-slider">
			<div class="badg">
				<p>
					<a href="#">Popular.</a>
				</p>
			</div>
			<div class="flexslider">
				<ul class="slides">
					<c:forEach items="${latetyNew}" var="item">
						<li><img src="${contextPath}/resources/images/${item.image1}"
							alt="MyPassion" width="540" height="372" />
							<p class="flex-caption">
								<a href="${contextPath}/new/${item.id}">${item.title}</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<c:forEach items="${hotNew}" var="item">
		<div class="slider3">
			<a href="#"><img src="${contextPath}/resources/images/${item.image1}" width="180" height="135"
				alt="MyPassion" /></a>
			<p class="caption">
				<a href="${contextPath}/new/${item.id}">${item.title}</a>
			</p>
		</div>
		</c:forEach>

	</div>
</section>