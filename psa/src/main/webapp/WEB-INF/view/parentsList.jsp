<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">


<link type="text/css" rel="stylesheet"
	href='<spring:url value="/resources/css/style.css" htmlEscape="true"/>' />



<title>Parents Step Ahead Login page</title>
</head>
<body>

	<br>
	<br>

	<div class="container">


		<div class="row justify-content-md-center">
			<div class="col col-lg-2"></div>

			<div class="col-md-auto bluebg border text-white ">
				<br>
				<h3>Parents' List</h3>
				<small>
					<p class="text-white">Don't share this information with anyone
						else.</p>
				</small>

				<form>

					<div class="form-group col-md-12">
						<label for="inputEmail4">Search</label> <input type="email"
							class="form-control" id="inputEmail4" placeholder="Search">
					</div>
					<div class="container">
						<div class="row">
							<div class="col-sm"></div>
							
							<div class="col-sm">					
								<button type="submit" class="btn btn-primary"
									onclick="window.location.href='childForm'; return false;">Search
								</button></div>
								
							<div class="col-sm"></div>
						</div>
					</div>
					<br>

					<button type="submit" class="btn btn-primary"
						onclick="window.location.href='registrationForm'; return false;">Add</button>
					<br> <br>

					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">First Name</th>
								<th scope="col">Country of Origin</th>
								<th scope="col">Salary Range</th>
								<th scope="col"># of Children</th>
								<th scope="col">Phone Number</th>
								<th scope="col">email</th>
								<th scope="col">Street</th>
								<th scope="col">State</th>
								<th scope="col">Zip Code</th>
								<th scope="col">Read | Edit | Delete</th>
							</tr>	
						</thead>
						
				<!-- loop over and print our customers -->
				<c:forEach var="tempParent" items="${ParentsList}"> 
						
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>Edit | Delete</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>Edit | Delete</td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td>Larry</td>
								<td>the Bird</td>
								<td>Edit | Delete</td>
							</tr>
						</tbody>
						
					</c:forEach>
					</table>

					<button type="submit" class="btn btn-primary"
						onclick="window.location.href='homeApp'; return false;">Submit</button>
					<br> <br>

				</form>

			</div>

			<div class="col col-lg-2"></div>
		</div>
	</div>



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>