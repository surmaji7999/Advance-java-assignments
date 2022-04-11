<%@ page import="entity.User, java.util.List,java.util.ArrayList"%>
<%
String userName = (String) session.getAttribute("USERNAME");
System.out.print(userName);
if (userName == null) {
	response.sendRedirect("Login.jsp");
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function check() {
		onsole.log("hii");
		console.log(event);
		var searchValue = document.forms["searchForm"]["searchData"].value;

		console.log(searchValue);
		if (searchValue == null) {
			alert("Text field empty !");
			return false;
		}

	}
</script>
<meta charset="ISO-8859-1">
<title>Search-page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<!-- nav bar satrted -->

	<nav class="navbar navbar-expand-lg navbar-dark  bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">HOTWAX system</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="Home">Home
					</a></li>
					<li class="nav-item"><a class="nav-link " aria-current="page"
						href="Search.jsp">Search</a></li>
				</ul>
				<ul class="navbar-nav mr-right">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href=""><%=session.getAttribute("USERNAME")%> </a></li>
					<li class="nav-item"><a class="nav-link " aria-current="page"
						href="Logout">Logout</a></li>

				</ul>

			</div>
		</div>
	</nav>
	<!-- nav bar end -->
	<!-- <div class="col-md-6">
						<label for="inputCity" class="form-label">City</label> 
						<input type="text" class="form-control" name="inputCity"placeholder="City" required>
					</div> -->

	<div class=" container col-md-3 mt-5">
		<div class="card">

			<div class="card-header">Search by First name/Last name</div>
			<div class="card-body">

				<form name="searchForm" action="Search" method="post"
					onsubmit="return check()">

					<div class="form-check">
						<input class="form-check-input" type="radio" name="searchType"
							id="flexRadioDefault1" value="firstName"> <label
							class="form-check-label" for="flexRadioDefault1"> First
							name </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="searchType"
							id="flexRadioDefault2" value="lastName" checked> <label
							class="form-check-label" for="flexRadioDefault2"> Last
							name </label>
					</div>
					<input type="text" name="searchData"
						placeholder="First name/last name">
					<button type="submit" class="btn btn-outline-success">Search</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>