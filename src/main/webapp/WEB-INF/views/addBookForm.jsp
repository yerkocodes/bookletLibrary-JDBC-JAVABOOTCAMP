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

	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container">
			<a class="navbar-brand" href="/bookManager/home">Booklet Library</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="/bookManager/home">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/bookManager/newBook">Add Book</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/bookManager/search">Search Book</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<section>
		<form:form class="row g-3 needs-validation container ms-auto" action="/bookManager/addBook" modelAttribute="bookForm">

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


	<!-- BOOTSTRAP -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

</body>
</html>