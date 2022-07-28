<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- BOOTSTRAP -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>

	<%@ include file="layouts/navbar.html" %>
	
	<main>
	
	<section class="container mx-auto my-5">
		<div class="alert alert-secondary text center" role="alert">
  			<c:out value="${statusMessage}"></c:out>
		</div>
			
	</section>

	<section class="container mx-auto my-5">
		<c:choose>
			<c:when test="${bookList.isEmpty()}">
				<div class="alert alert-danger text-center" role="alert">
					The list is empty
				</div>
			</c:when>
			
			<c:when test="${!bookList.isEmpty()}">
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
											<a class="btn btn-danger" href="/delete?book_id=${book.getBook_id()}">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
		</c:choose>
	</section>
	
	</main>


	<%@ include file="layouts/searchModal.html" %>

	<!-- BOOTSTRAP -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

</body>
</html>