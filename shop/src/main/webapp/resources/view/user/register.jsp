<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		 <div class="col-md-12">
			<form:form modelAttribute="formUser" method="Post">
				userName<form:input path="username"/>
				Password<form:input path="password"/>
				<input type="submit" value="register"/>
			</form:form>
		
		</div>
	</div>
</div>