<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../fragments/header.jsp" />
<body>

<jsp:include page="../fragments/nav.jsp" />

<div class="container">
<h3>Login</h3>
<hr />
<div class="row">
<div class="col-md-6 offset-md-3">
			<form:form method="POST" action="login" modelAttribute ="loginCModel">		    
		        <div class="form-group">
			        <form:label path="email">Email: </form:label> 
			        <form:input class="form-control" path="email"></form:input>
		        </div>
		        <div class="form-group">
			        <form:label path="password">Password: </form:label> 
			        <form:input class="form-control" path="password"></form:input> 
 			    </div>
		        <div class="invalid-feedback">
			        <form:errors path="*" />
		        </div>
		        <input class="btn btn-primary" type="submit" value="Submit"/>
		  	</form:form>
</div>
	</div>
	</div>
<jsp:include page="../fragments/footer.jsp"/>
	</body>
</html>