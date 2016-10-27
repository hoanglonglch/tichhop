	<div class="container">
		<form:form method="POST" modelAttribute="categoryForm" action="newParent">
			<div class="form-group">
				<label for="exampleInputEmail1">Category</label>
				<form:input path="name" class="form-control" disabled="false"/>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail2">Parent category</label>
				<form:input path="parentCate.parentName" class="form-control" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
	
	
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input type="file" id="exampleInputFile">
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>Z	
	<!-- <div class="container">
		<form:form method="POST" modelAttribute="categoryForm">
				<form:input path="name"/><br>
				<form:input path="parentCate.parentName"/><br>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div> -->
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr id="listShopView">
					<th>id</th>
					<th>category</th>
					<th>category parent</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>${category.parentCate.parentName}</td>
					</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
