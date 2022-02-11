<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Expense Detail</title>
</head>
<body>
	<div>
		<h1>Expense Details</h1>
		<a href="/expenses">Go back</a>
		<hr/>
		<p>Expense: ${expense.expense}</p>
		<p>Vendor: ${expense.vendor} </p>
		<p>Amount: ${expense.amount}</p>
		<p>Description: ${expense.description}</p>
	</div>

</body>
</html>