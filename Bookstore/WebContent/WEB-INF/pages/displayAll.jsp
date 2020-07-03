<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="../fragments/header.jsp" />
<body>

	<jsp:include page="../fragments/nav.jsp" />

	<div class="container">
		<h3>All Books in Library</h3>
		<hr />
		<center>
			<div class="row d-flex justify-content-center">
				<c:forEach items="${books}" var="book">
					<div class="col-sm-12 col-md-4">
						<div class="card text-center" style="width: 18rem;">
							<div class="card-body">
								<h5 class="card-title">${book.title}</h5>
								<button id="${book.title}" class="btn btn-primary bookButton"
									data-toggle="modal" type="button" data-target="#bookModal"
									data-appId="${book.appId}" data-title="${book.title}"
									data-author="${book.author}" data-publisher="${book.publisher}"
									data-isbn="${book.ISBN}">Details</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</center>
	</div>

	<script>
		$(document).on('click', '.btn', function() {
			var appId = $(this).attr('data-appId');
			var title = $(this).attr('data-title');
			var author = $(this).attr('data-author');
			var publisher = $(this).attr('data-publisher');			
			var isbn = $(this).attr('data-isbn');
			
			// Set modal attributes
			$('.modal').find('#booktitle').text(title);
			$('.modal').find('#bookauthor').text(author);
			$('.modal').find('#bookpublisher').text(publisher);
			$('.modal').find('#bookisbn').text(isbn);
			
			// Set Update/Delete button actions
			$('#updateBtn').click(function () {
				location.href = appId + "/update";
			});
			$("#deleteBtn").click(function () {
				$.ajax({ 
					url: appId + '/delete',
					type: 'POST',
					success: function(result) {
						alert("Successfully deleted book entry!");
						location.href= "displayAll";
					},
					error: function(_, status) {
						alert("Failed with error: " + status);
					}
				});
			});
		});
	</script>


	<!-- MODAL CODE -->


	<div class="modal fade right" id="bookModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

		<!-- Add class .modal-full-height and then add class .modal-right (or other classes from list above) to set a position to the modal -->
		<div class="modal-dialog modal-full-height modal-right"
			role="document">


			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title w-100" id="myModalLabel">Modal title</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<strong>Title: </strong><span id="booktitle"></span> <br />
					<hr />
					<strong>Author: </strong><span id="bookauthor"></span> <br />
					<hr />
					<strong>Publisher: </strong><span id="bookpublisher"></span> <br />
					<hr />
					<strong>ISBN: </strong><span id="bookisbn"></span> <br>
				</div>
				<div class="modal-footer justify-content-center">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
				<button id="updateBtn" class="btn btn-primary" onclick="">Update</button>
				<button id="deleteBtn" class="btn btn-danger" onclick="">Delete</button>
			</div>
		</div>
	</div>
	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>


