<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="count" value="1" />
<div class="column-two-third">
	<c:forEach items="${listNew}" var="item">
		<c:choose>
			<c:when test="${count %2 !=0}">
				<div class="outertight m-t-no">
					<div class="badg">
						<p>
							<a href="#">Featured.</a>
						</p>
					</div>
					<div class="flexslider">
						<ul class="slides">
							<li><img
								src="${contextPath}/resources/images/${item.image1}" width="300"
								height="162" alt="MyPassion" /></li>
						</ul>
					</div>

					<h6 class="regular">
						<a href="single.html">${item.title}</a>
					</h6>
					<span class="meta">26 May, 2013. \\ <a href="#">World
							News.</a> \\ <a href="#">No Coments.</a></span>
					<p>${item.splitContent}</p>
					<c:set value="${count +1}" var="count" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="outertight m-r-no m-t-no">
					<div class="badg">
						<p>
							<a href="#">Featured.</a>
						</p>
					</div>
					<div class="flexslider">
						<ul class="slides">
							<li><img
								src="${contextPath}/resources/images/${item.image1}" width="300"
								height="162" alt="MyPassion" /></li>
						</ul>
					</div>

					<h6 class="regular">
						<a href="single.html">${item.title}</a>
					</h6>
					<span class="meta">26 May, 2013. \\ <a href="#">World
							News.</a> \\ <a href="#">No Coments.</a></span>
					<p>${item.splitContent}</p>
				</div>
				<c:set value="${count +1}" var="count" />
			</c:otherwise>
		</c:choose>
	</c:forEach>


	<div class="pager">
		<ul>
	<c:forEach var="page" begin="0" end="${totalPage-1}">
			<li><a href="${contextPath}/parentCateNew/${idParent}/${page}">${page+1}</a></li>
	</c:forEach>
		</ul>
	</div>

</div>