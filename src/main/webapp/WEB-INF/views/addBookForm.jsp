<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookLet</title>

<!-- BOOTSTRAP -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>

	<%@ include file="layouts/navbar.html" %>

	<section>
		<form:form class="row g-3 needs-validation container mx-auto my-5" action="/bookManager/addBook" modelAttribute="bookForm">

			<div class="col-md-4">
				<label for="validationCustom01" class="form-label">Author Name</label> 
					<input type="text" class="form-control" id="validationCustom01" name="author" required>
				<div class="valid-feedback">Looks good!</div>
			</div>

			<div class="col-md-4">
				<label for="validationCustom02" class="form-label">Book Title</label>
				<input type="text" class="form-control" id="validationCustom02" name="title" required>
				<div class="valid-feedback">Looks good!</div>
			</div>

			<div class="col-md-4">
				<label for="validationCustom02" class="form-label">Year</label>
				<input type="number" class="form-control" id="validationCustom02" name="year" required>
				<div class="valid-feedback">Looks good!</div>
			</div>

			<div class="col-md-3">
				<label for="validationCustom04" class="form-label">State</label> 
				<select class="form-select" id="validationCustom04" name="sellable" required>
					<option selected disabled value="">Choose an option...</option>
					<option value="true">Available</option>
					<option value="false">Not available</option>
				</select>
				<div class="invalid-feedback">Please select a valid state.</div>
			</div>

			<div class="col-md-3">
				<label for="validationCustom05" class="form-label">Printing name</label> 
				<input type="text" class="form-control" id="validationCustom05" name="printing" required>
				<div class="invalid-feedback">Please provide a valid zip.</div>
			</div>

			<div class="col-12">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="invalidCheck" required> <label
						class="form-check-label" for="invalidCheck"> Agree to
						terms and conditions </label>
					<div class="invalid-feedback">You must agree before
						submitting.</div>
				</div>
			</div>
			<div class="col-12">
				<button class="btn btn-primary" type="submit">Add new Book</button>
			</div>
		</form:form>
	</section>

	<%@ include file="layouts/searchModal.html" %>

	<!-- BOOTSTRAP -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

</body>
</html>