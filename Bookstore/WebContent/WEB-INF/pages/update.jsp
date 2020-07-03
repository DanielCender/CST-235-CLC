<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../fragments/header.jsp" />
<body>

<jsp:include page="../fragments/nav.jsp" />


  <div class="container">
<h3>Update Book Entry</h3>
<hr />

<form:form method="POST" action="update" modelAttribute ="book">
 	<div class="form-group">
        <form:label path="title">Title: </form:label>
         <form:input path="title" class="form-control" value="${book.title}"></form:input> 
        <form:errors path="title" />
        </div>
        <div class="form-group">
         <form:label path="author">Author: </form:label>
          <form:input path="author" class="form-control" value="${book.author}"></form:input> 
          <form:errors path="author" />
        </div>
        <div class="form-group">
        <form:label path="ISBN">ISBN: </form:label> 
         <form:input path="ISBN" class="form-control" value="${book.ISBN}"></form:input> 
         <form:errors path="ISBN" />
        </div>
        <div class="form-group">
        <form:label path="publisher">Publisher: </form:label>
         <form:input path="publisher" class="form-control" value="${book.publisher}"></form:input> 
         <form:errors path="publisher" />
        </div>

        <form:hidden path="appId" value="${book.appId}"></form:hidden>        
        <form:errors path="*" cssClass="error"/>
        
        <input type="submit" class="btn btn-primary" value="Submit" />

</form:form>
</div>
 
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>