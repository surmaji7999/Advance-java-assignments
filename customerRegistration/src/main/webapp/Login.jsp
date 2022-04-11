<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
session.setMaxInactiveInterval(2);
%>

<script type="text/javascript">
var Msg ='<%=session.getAttribute("getAlert")%>
	';
	if (Msg != "null") {
		function alertName() {
			alert(Msg);
		}
	}
</script>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Login page</title>

</head>
<body>
	<!-- nav bar -->
	<%@ include file="NavBar.jsp"%>

	<main class="mt-5 ">
		<div class="row">
			<div class="container">
					
				<div class=" card col-md-4 offset-md-4 ">
				<%@ include file="Massage.jsp" %>
					<div>
						<div class="card-header card text-center text-light"
							style="background-color: #198754;">
							<h3>Login here</h3>
							<i class="fa fa-user-circle mt-2" style="font-size: 36px"></i>
						</div>

						<div class="card-body">

							<form method="post" action="Login" onsubmit="return f1()">
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">User
										id</label> <input name="user-id" placeholder="Enter id" type="email"
										class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" required>

								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Password</label>
									<input name="password" placeholder="Enter password"
										type="password" class="form-control"
										id="exampleInputPassword1" required>
								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-outline-success ">Login</button>
								</div>

							</form>

						</div>
						<div class="card-footer text-muted card text-center">
							Are you not registered ? <a href="Registration.jsp">click
								here </a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		window.onload = alertName;
	</script>
</body>
</html>