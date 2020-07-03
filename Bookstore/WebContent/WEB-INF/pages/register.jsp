<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../fragments/header.jsp" />
<body>

<jsp:include page="../fragments/nav.jsp" />

<div class="container">
	<h3>User Registration</h3>
<hr/>
		<form:form method="POST" action="register" modelAttribute ="userRegistration">
			<div class="form-row">
	    	<div class="form-group col-md-5">
		        <form:label path="firstName" for="inputFirstName">First Name: </form:label>
		        <form:input class="form-control" id="inputFirstName" path="firstName"></form:input> 
		        <div class="invalid-feedback">
			        <form:errors path="firstName" />
			    </div>
		    </div>
	        <div class="form-group col-md-2">
		        <form:label path="middleInitial" for="inputMiddleName">Middle Initial: </form:label>
	        	<form:input class="form-control" id="inputMiddleName"  path="middleInitial"></form:input> 
	        	<div class="invalid-feedback">
	        		<form:errors path="middleInitial" />
	        	</div>
	        </div>
	        <div class="form-group col-md-5">
		        <form:label path="lastName" for="inputLastName">Last Name: </form:label> 
		        <form:input class="form-control" id="inputLastName" path="lastName"></form:input> 
		        <div class="invalid-feedback">
		        	<form:errors path="lastName" />
		        </div>
	        </div>
	        </div>
	        <div class="form-group">
		        <form:label path="email">Email: </form:label>
		        <form:input class="form-control" path="email"></form:input> 
		        <div class="invalid-feedback">
			        <form:errors path="email" />
			    </div>
	        </div>
			<div class="form-group">
		        <form:label path="username">Username: </form:label>
		        <form:input class="form-control" path="username"></form:input> 
		        <div class="invalid-feedback">
		        	<form:errors path="username"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <form:label path="password">Password: </form:label>
		        <form:input class="form-control" path="password"></form:input> 
		        <div class="invalid-feedback">
		        	<form:errors path="password" />
		        </div>
	        </div>
	     	<div class="form-group">
		        <form:label path="passwordConfirmation">Confirm Password: </form:label>
		        <form:input class="form-control" path="passwordConfirmation"></form:input> 
		        <div class="invalid-feedback">
			        <form:errors path="passwordConfirmation" />
	        	</div>
	        </div>
	        <input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>
</div>
    	<jsp:include page="../fragments/footer.jsp"/>
	</body>
</html>