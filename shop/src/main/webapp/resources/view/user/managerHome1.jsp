<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="i" value="0"></c:set>
<!-- Life Style -->
<div class="column-two-third">
	<h5 class="line">
		<!--this load parent cate-->
		<span>The Thao</span>
		<div class="navbar">
			<a id="next1" class="next" href="#"><span></span></a> <a id="prev1"
				class="prev" href="#"><span></span></a>
		</div>
	</h5>
	<c:forEach items="${listSport}" var="new1">
		<c:choose>
			<c:when test="${i==0}">
				<div class="outertight">
					<img src="${contextPath}/resources/images/${new1.image1}"
						alt="MyPassion" width="300" height="162"/>
					<h6 class="regular">
						<a href="new/${new1.id}">${new1.title}</a>
					</h6>
					<span class="meta">26 May, 2013. \\ <a href="#">${new1.category.name}</a></span>
						${new1.splitContent}...
	<c:set var="i" value="1"></c:set>
				</div>
			</c:when>
			<c:otherwise>
				<div class="outertight m-r-no">
					<ul class="block" id="carousel">
						<li><a href="#"><img
								src="${contextPath}/resources/images/${new1.image1}"
								alt="MyPassion" class="alignleft" height="86" width="140" /></a>
							<p>
								<span>${new1.title}</span> <a href="#">${new1.splitContent2}...</a>
							</p></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>



	</c:forEach>
</div>

