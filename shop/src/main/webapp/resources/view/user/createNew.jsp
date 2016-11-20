<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>

<div class="container">
	<h2 class="text-center">create news</h2>
	<form:form modelAttribute="newForm" action="createNew"
		enctype="multipart/form-data" method="POST">

		<div class="form-group">
			<label for="category">category</label>
			<form:select path="category.name" action="select">
				<form:options items="${listCategory}"></form:options>
			</form:select>
		</div>

		<div class="form-group">
			<label for="title">title</label>
			<form:input path="title" class="form-control" />
		</div>

		<div class="form-group">
			<label for="exampleInputFile">input image1</label>
			<div class="form-group">
				<label for="exampleInputFile" class="sr-only">File input</label> <input
					type="file" name="listFile">
			</div>
		</div>
		<div class="form-group text-center">
			<label for="comment" class="bg-danger ">content 1</label>
			<form:textarea path="content1" class="form-control" rows="10"
				id="content1" />
		</div>

		<%-- <div class="form-group">
			<label for="exampleInputFile">date time</label>
			<div class="form-group">
				<form:input path="date" type="date" pattern="yyyy-MM-dd"/>
				<!-- <p>Date: <input type="text" id="datepicker"></p> -->
				<form:input path="date" type="text"  id="datepicker"/>

			</div>
		</div> --%>


		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
</div>
<ckeditor:replace replace="content1" basePath="/ckeditor1/" />
<ckfinder:setupCKEditor basePath="/shop/resources/ckfinder" />