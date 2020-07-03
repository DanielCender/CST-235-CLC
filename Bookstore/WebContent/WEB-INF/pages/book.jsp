<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../fragments/header.jsp" />
<body>

<jsp:include page="../fragments/nav.jsp" />

<div class="container">
<h3>Book Details:</h3>
<hr />
<div class="row table-responsive">
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>ISBN</th>
			<th>Publisher</th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td>${book.title}</td>
		<td>${book.author}</td>
		<td>${book.ISBN}</td>
		<td>${book.publisher}</td>
	</tr>
	</tbody>
</table>
</div>
</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>