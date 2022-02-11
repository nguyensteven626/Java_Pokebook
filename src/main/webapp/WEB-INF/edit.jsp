<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- additional tags to add -->
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<nav>
		<h1>Edit Expense</h1>
		<a href="/expenses">Go back</a>
	</nav>
	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
	    <input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="expense">Expense Name: </form:label>
	        <form:errors path="expense"/>
	        <form:input path="expense" type="text" name="expense"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor: </form:label>
	        <form:errors path="vendor" />
			<form:input path="vendor" />
	    </p>
	    <p>
	        <form:label path="amount">Amount: </form:label>
	        <form:errors path="amount" />
	        <form:input path="amount" />
	    </p>
	    <p>
	        <form:label path="description">Description: </form:label>
	        <form:errors path="description" />     
	        <form:textarea path="description"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>
	<a href="/expenses"> Home</a>
</body>
</html>