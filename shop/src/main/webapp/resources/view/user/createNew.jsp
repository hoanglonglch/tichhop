<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	<h2 class="text-center">create news</h2>
	<form:form modelAttribute="newForm" action="createNew"
		enctype="multipart/form-data" method="POST">
		<div class="form-group">
			<label for="category">category</label>
			<form:input path="category.name" class="form-control" />
		</div>
		<div class="form-group">
			<label for="title">title</label>
			<form:input path="title" class="form-control" />
		</div>

		<div class="form-group text-center">
			<label for="comment" class="bg-danger ">content 1</label>
			<form:textarea path="content1" class="form-control" rows="10"
				id="comment1" />
		</div>
		<div class="form-group">
			<label for="exampleInputFile">input image1</label>
			<div class="form-group">
				<label for="exampleInputFile" class="sr-only">File input</label> <input
					type="file" name="listFile">
			</div>
		</div>
		<div class="input-group">
			<form:input path="imageTitle1" class="form-control"
				placeholder="Recipient's username" aria-describedby="basic-addon2" />
			<span class="input-group-addon" id="basic-addon2">imageTitle1</span>
		</div>
		<hr>
		<div class="form-group text-center">
			<label for="comment" class="bg-danger ">content 2</label>
			<form:textarea path="content2" class="form-control" rows="10"
				id="comment1" />
		</div>
		<div class="form-group">
			<label for="exampleInputFile">input image2</label>
			<div class="form-group">
				<label for="exampleInputFile" class="sr-only">File input</label> <input
					type="file" name="listFile">
			</div>
		</div>
		<div class="input-group">
			<form:input path="imageTitle2" class="form-control"
				placeholder="Recipient's username" aria-describedby="basic-addon2" />
			<span class="input-group-addon" id="basic-addon2">imageTitle2</span>
		</div>
		<hr>




		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
</div>