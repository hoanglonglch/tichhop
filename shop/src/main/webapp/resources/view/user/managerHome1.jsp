<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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

	<div class="outertight">
		<img src="img/trash/24.png" alt="MyPassion" />
		<h6 class="regular">
			<a href="#">the thao</a>
		</h6>
		<span class="meta">26 May, 2013. \\ <a href="#">Categories
				Name.</a></span>
		<p>using striplet to find substring</p>
	</div>

	<div class="outertight m-r-no">
		<ul class="block" id="carousel">
		
		<c:forEach items="${listNew}" var="new1">
				<li><a href="#"><img
								src="${contextPath}/resources/images/${new1.image1}"
								alt="MyPassion" class="alignleft" height="86" width="140" /></a>
					<p>
						<span>26 May, 2013.</span> <a href="#">${new1.id}</a>
					</p></li>

			</c:forEach>

		</ul>
	</div>
</div>

