<%@ include file ="common/header.jspf"%>
<body>
	<div class="container">
	Hi Your Todos are : <br/>
	<BR/>
	<table class = "table table-striped table-hover">
		<caption>Todos</caption>
		<thead>
		<tr>
			<th>Description</th>
			<th>Date</th>
			<th>isCompleted</th>
		</tr>
		</thead>
	<c:forEach items="${todos}" var="item">
		<tr>
			<td>${item.getDesc()}</td>
			<td><fmt:formatDate value="${item.getDate()}" pattern="dd/MM/yyyy"/></td>
			<td>${item.isCompleted()}</td>
			<td><a href ="/update-todo?id=${item.getId()}"><button class ="btn btn-warning">Update</button></a></td>
			<td><a href ="/delete-todo?id=${item.getId()}"><button class ="btn btn-danger">Delete</button></a></td>
			
		</tr>
	</c:forEach>

</table>

	<a href ="/add-todo"><button class ="btn btn-success">Add</button></a>
</div>
<%@ include file ="common/footer.jspf"%>

</body>
</html>