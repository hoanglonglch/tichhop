<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Life Style -->
<c:forEach items="${parentCates}" var="parentCate">
	<div class="column-two-third">
		<h5 class="line">
			<!--this load parent cate-->
			<span>${parentCate.parentName}</span>
			<div class="navbar">
				<a id="next1" class="next" href="#"><span></span></a> <a id="prev1"
					class="prev" href="#"><span></span></a>
			</div>
		</h5>

		<div class="outertight">
			<img src="img/trash/24.png" alt="MyPassion" />
			<h6 class="regular">
				<a href="#">this is title</a>
			</h6>
			<span class="meta">26 May, 2013. \\ <a href="#">Categories
					Name.</a></span>
			<p>using striplet to find substring</p>
		</div>

		<div class="outertight m-r-no">

			<ul class="block" id="carousel">
				<li><a href="#"><img src="img/trash/13.png" alt="MyPassion"
						class="alignleft" /></a>
					<p>
						<span>26 May, 2013.</span> <a href="#">Title.</a>
					</p></li>



			</ul>
		</div>
	</div>
</c:forEach>