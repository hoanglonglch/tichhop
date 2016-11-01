<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="i" value="0"></c:set>
<!-- Life Style -->
	<c:forEach items="${parentCates}" var="parentCate">
	<div class="column-two-third">
		<h5 class="line">
			<!--this load parent cate-->
			<span>${parentCate.parentName}</span>

			<!-- scroll bar using jquerry -->
			<div class="navbar">
				<a id="next1" class="next" href="#"><span></span></a> <a id="prev1"
					class="prev" href="#"><span></span></a>
			</div>
		</h5>
		
		<!-- load list cate then load list new -->
		<c:forEach items="${parentCate.categories}" var="category">
		<c:forEach items="${category.news}" var="new1">
		
		
		<!-- using c:if here -->
		<c:if test="${i == 0 }">
		<div class="outertight">
			<img src="${contextPath}/resources/images/${new1.image1}" alt="MyPassion" />
			<h6 class="regular">
				<a href="#">${new1.title}</a>
			</h6>
			<span class="meta">26 May, 2013. \\ <a href="#">Categories
					Name.</a></span>
			<p>using striplet to find substring</p>
		</div>
		<c:set var="i" value="1"></c:set>
	</c:if>
		<div class="outertight m-r-no">

			<ul class="block" id="carousel">
				<li><a href="#"><img src="${contextPath}/resources/images/${new1.image1}" alt="MyPassion"
						class="alignleft" /></a>
					<p>
						<span>26 May, 2013.</span> <a href="#">new1.title.</a>
					</p></li>


			</ul>
		</div>
		</c:forEach>
		</c:forEach>
	</div>
</c:forEach>
<!-- /Life Style -->