<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Expense:</th>
				<th>Vendor:</th>
				<th>Amount:</th>
				<th>Description:</th>
				<th>Action:</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><c:out value="${expense.expense }"></c:out></td>
					<td><c:out value="${expense.vendor }"></c:out></td>
					<td><c:out value="${expense.amount }"></c:out></td>
					<td><c:out value="${expense.description }"></c:out></td>
					<td>
						<a href="/expenses/${expense.id}/edit">edit</a>
						<form action="/expenses/${expense.id}/delete" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form  action="/expenses" method="post" modelAttribute="expense">
	   	 		<form:errors path="expense"/>
	   	 		<p>
	        		<form:label path="expense">Expense Name: </form:label>
	        		<form:input  type="text" name="expense" path="expense"/>
	    		</p>
	    		<form:errors  path="vendor"/>
	    		<p>
			        <form:label path="vendor">Vendor: </form:label>
			        <form:input  type="text" path="vendor"/>
			    </p>
			    <form:errors path="amount"/><br/>
			    <p>
			        <form:label path="amount">Amount: </form:label>
			        <form:input type="number" step="0.01" path="amount"/>
			    </p> 
			    <form:errors path="description"/>
			    <p>
			        <form:label path="description">Description: </form:label><br/>
			        <form:textarea path="description" rows="3"/>
			    </p> 
			    <input type="submit" value="Submit"/>
			</form:form>   
</body>
</html>