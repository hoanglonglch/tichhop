
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<header id="header">
	<div class="container">
		<div class="column">
			<div class="logo">
				<a href="index-2.html"><img src="${contextPath}/resources/img/logo.png" alt="MyPassion" /></a>
			</div>

			<div class="search">
				<form action="#" method="post">
					<input type="text" value="Search."
						onblur="if(this.value=='') this.value='Search.';"
						onfocus="if(this.value=='Search.') this.value='';" class="ft" /> <input
						type="submit" value="" class="fs">
				</form>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul class="sf-menu">
					<li class="current"><a href="index-2.html">Home.</a></li>
					
					<c:forEach items="${parentCates}" var="parentCate">
						<li><a href="${contextPath}/parentCateNew/${parentCate.id}/0">${parentCate.parentName}</a>
							<ul>
							<c:forEach items="${parentCate.categories}" var="category">
								<li><i class="icon-right-open"></i><a
								href="#">${category.name}</a></li>
							</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>

			</nav>
			<!-- /Nav -->
		</div>
	</div>
</header>