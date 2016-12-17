<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="column-one-third">
                	<div class="sidebar">
                    	<h5 class="line"><span>Stay Connected.</span></h5>
                        <ul class="social">
                        	<li>
                            	<a href="#" class="facebook"><i class="icon-facebook"></i></a>
                                <span>6,800 <br/> <i>fans</i></span>
                            </li>
                            <li>
                            	<a href="#" class="twitter"><i class="icon-twitter"></i></a>
                                <span>12,475 <br/> <i>followers</i></span>
                            </li>
                            <li>
                            	<a href="#" class="rss"><i class="icon-rss"></i></a>
                                <span><i>Subscribe via rss</i></span>
                            </li>
                        </ul>
                    </div>
                    
                   
                    
                    <div class="sidebar">
                    	<h5 class="line"><span>Ads Spot.</span></h5>
                        <ul class="ads125">
                        	<li><a href="#"><img src="/shop/resources/img/banner/icon1.jpg" alt="MyPassion" width="125" height="125"/></a></li>
                        	<li><a href="#"><img src="/shop/resources/img/banner/3.png" alt="MyPassion" width="125" height="125"/></a></li>
                        	<li><a href="#"><img src="/shop/resources/img/banner/3.png" alt="MyPassion" width="125" height="125"/></a></li>
                        	<li><a href="#"><img src="/shop/resources/img/banner/banner_design.png" alt="MyPassion" width="125" height="125"/></a></li>
                        </ul>
                    </div>
                    
                    <!-- this slider will load related post -->
                    <div class="sidebar">
                    	<div id="tabs">
                            <ul>
                                <li><a href="#tabs1">Recent.</a></li>
                                <li><a href="#tabs2">Popular.</a></li>
                                
                            </ul>
                            <div id="tabs1">
                                <ul>
                                <c:forEach items="${latetyNew}" var="item">
                                    <li>
                                    	<a href="${contextPath}/new/${item.id}" class="title">${item.title}</a>
                                        <span class="meta">26 May, 2013.\\<a href="#">${item.category.name}</a>  
                                        <span class="rating"><span style="width:70%;"></span></span>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div id="tabs2">
                                <ul>
                                <c:forEach items="${hotNew}" var="item">
                                    <li>
                                    	<a href="${contextPath}/new/${item.id}" class="title">${item.title}</a>
                                        <span class="meta">26 May, 2013.\\<a href="#">${item.category.name}</a>  
                                        <span class="rating"><span style="width:70%;"></span></span>
                                    </li>
							</c:forEach>
                                </ul>
                            </div>
                            
                        </div>
                    </div>
                    
                   
                  <!--   
                    <div class="sidebar">
                    	<h5 class="line"><span>Ads Spot.</span></h5>
                        <a href="#"><img src="/shop/resources/img/tf_300x250_v1.gif" alt="MyPassion" /></a>     
                    </div> -->
                	
                    <div class="sidebar">
                    	<h5 class="line"><span>Facebook.</span></h5>
                        <iframe src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Fenclaveit%2F%3Ffref%3Dts&tabs=timeline&width=298&height=258&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId" width="298" height="258" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowTransparency="true"></iframe>
                    </div>
                </div>