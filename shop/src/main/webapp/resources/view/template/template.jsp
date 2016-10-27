<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description"
	content="News - Clean HTML5 and CSS3 responsive template">
<meta name="author" content="MyPassion">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<title>News - Responsive HTML5 and CSS3 template</title>

<link rel="shortcut icon" href="img/sms-4.ico" />

<!-- STYLES -->
<link rel="stylesheet" type="text/css"
	href="./resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="./resources/css/superfish.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="./resources/css/fontello/fontello.css" />
<link rel="stylesheet" type="text/css"
	href="./resources/css/flexslider.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./resources/css/ui.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/base.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/960.css" />
<link rel="stylesheet" type="text/css"
	href="./resources/css/devices/1000.css"
	media="only screen and (min-width: 768px) and (max-width: 1000px)" />
<link rel="stylesheet" type="text/css"
	href="./resources/css/devices/767.css"
	media="only screen and (min-width: 480px) and (max-width: 767px)" />
<link rel="stylesheet" type="text/css"
	href="./resources/css/devices/479.css"
	media="only screen and (min-width: 200px) and (max-width: 479px)" />
<link
	href='http://fonts.googleapis.com/css?family=Merriweather+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>
<!--[if lt IE 9]> <script type="text/javascript" src="./resources/js/customM.js"></script> <![endif]-->


</head>
<body>
	<div class="body-wrapper">
		<div class="controller">
			<div class="controller2">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="slider" />
				<section id="content">
					<div class="container">
						<div class="main-content">
							<tiles:insertAttribute name="body" />
							<%-- <tiles:insertAttribute name="leftSide" /> --%>
						</div>
					</div>
				</section>

				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</div>

<!-- SCRIPTS -->
<script type="text/javascript" src="./resources/js/jquery.js"></script>
<script type="text/javascript" src="./resources/js/easing.min.js"></script>
<script type="text/javascript" src="./resources/js/1.8.2.min.js"></script>
<script type="text/javascript" src="./resources/js/ui.js"></script>
<script type="text/javascript" src="./resources/js/carouFredSel.js"></script>
<script type="text/javascript" src="./resources/js/superfish.js"></script>
<script type="text/javascript" src="./resources/js/customM.js"></script>
<script type="text/javascript" src="./resources/js/flexslider-min.js"></script>
<script type="text/javascript" src="./resources/js/jtwt.min.js"></script>
<script type="text/javascript" src="./resources/js/jflickrfeed.min.js"></script>
<script type="text/javascript" src="./resources/js/mobilemenu.js"></script>

<!--[if lt IE 9]> <script type="text/javascript" src="./resources/js/html5.js"></script> <![endif]-->
<script type="text/javascript" src="./resources/js/mypassion.js"></script>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

