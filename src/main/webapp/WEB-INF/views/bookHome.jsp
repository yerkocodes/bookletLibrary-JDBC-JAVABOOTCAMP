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

	<%-- <jsp:include page="layouts/navbar.html"></jsp:include> --%>

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

	<div class="container mx-auto">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author</th>
					<th scope="col">Year</th>
					<th scope="col">Sellable</th>
					<th scope="col">Printing</th>
					<th scope="col"></th>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<th scope="row"><c:out value="${book.getBook_id()}"></c:out>
						</th>
						<td><c:out value="${book.getTitle()}"></c:out></td>
						<td><c:out value="${book.getAuthor()}"></c:out></td>
						<td><c:out value="${book.getYear()}"></c:out></td>

						<c:choose>
							<c:when test="${book.isSellable() == true}">
								<td class="text-success">Available</td>
							</c:when>

							<c:when test="${book.isSellable() == false}">
								<td class="text-danger">Not Available</td>
							</c:when>
						</c:choose>

						<td><c:out value="${book.getPrinting()}"></c:out></td>
						<td>
							<a class="btn btn-success" href="/changeSellable?book_id=${book.getBook_id()}&sellable=${!book.isSellable()}">Change availability</a> 
							<a class="btn btn-primary" href="/update?book_id=${book.getBook_id()}">Update</a> 
							<a class="btn btn-danger" href="/delete?book_id=${book.getBook_id()}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>




	<!-- BOOTSTRAP -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

</body>
</html>