<%@ include file ="common/header.jspf"%>

<body>
	<div class = "container">

	<H2>Add Todo</H2>
		
	<form:form method="post" modelAttribute = "todo">
	<fieldset class="form-group">
		<form:label path = "desc" >Description :</form:label>
		<form:input path = "desc" type="text" required="required" class="form-control"/>
		<form:errors path="desc" cssClass="text-warning"></form:errors>
	</fieldset>

	<fieldset class="form-group">
		<form:label path = "date" >Target Date :</form:label>
		<form:input path = "date" type="text" required="required" class="form-control"/>
		<form:errors path="date" cssClass="text-warning" id = "date"></form:errors>
	</fieldset>

		
		<input type="submit" name="ADD" class="btn btn-success"/>

	</form:form>
</div>
<%@ include file ="common/footer.jspf"%>
</body>
</html>