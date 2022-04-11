<%@ page errorPage="error.jsp" %> 
<%
	session = request.getSession(true);
	String userName = (String) session.getAttribute("USERNAME");
	if (userName == null) {
	    response.sendRedirect("Login.jsp");
	}
	%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Dao.UserDao,Dao.ConnectionProvider,entity.User"%>
<!DOCTYPE html>
<html>
<head>
<title>edit- page</title>
	<script type="text/javascript">
	function EditvValidate() {
		console.log("hii");
		console.log(event);
		 //event.preventDefault();
		
		/*  var name =      document.forms["RegForm"]["Name"];*/
		var firstName = document.forms["edit"]["inputFristName"].value;
		var lastName = document.forms["edit"]["inputLastName"].value;
		var address = document.forms["edit"]["inputAddress"].value;
		var city = document.forms["edit"]["inputCity"].value;
		var state = document.forms["edit"]["inputState"].value;
		var zip = document.forms["edit"]["inputZip"].value;
		var country = document.forms["edit"]["inputCountry"].value;
		var phone = document.forms["edit"]["inputPhone"].value;
		var email = document.forms["edit"]["inputPassword"].value;
		var password = document.forms["edit"]["inputPassword"].value;
		console.log(firstName);
		console.log("2")
		
		if (firstName.trim()== "" || firstName.trim().length < 3) {
			window.alert("please provide valide first name");
			firstName.focus();
			return false;
		}


		if (lastName.trim() =="" || lastName.trim().length< 3) {
			alert("please provide valide last name");
			return false;
		}

		if (address.trim() == "") {
			alert("please provide address");
			return false;
		}

		if (city.trim()== "" || city.trim().length< 3) {
			alert("please provide valide city");
			return false;
		}

		if (zip.trim()== "" || zip.trim().length < 6) {
			alert("please provide valide zip");
			return false;
		}

		if (state.trim() == "" || state.trim().length< 3) {
			alert("please provide valide state");
			return false;
		}

		if (country.trim()== "" || country.trim().length < 3) {
			alert("please provide valide country");
			return false;
		}

		if (phone.trim() == "" || (phone.trim().length< 10 && phone.trim().length > 10)) {
			alert("please provide valide phone number");
			return false;
		}
		if (email == "") {
			alert("please provide email");
			return false;
		}
		if (password.trim() == "" || password.trim().length< 6) {
			alert("please provide 6 or more characters in password");
			return false;
		}
		return true;
	}</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta charset="ISO-8859-1">

</head>
<body>

	<%
	String id1 = request.getParameter("id");

	UserDao userDao = new UserDao(ConnectionProvider.getConnection());

	User user = userDao.selectDataById(id1);
	%>
	
	<div class="container">
		<div class="card mt-5">
				
			<div class="card-header text-light text-center"
				style="background-color: #198754;">
				<h3>Edit</h3>
				<i class='fa fa-edit' style='font-size: 36px'></i>
			</div>
			<div class="card-body">

				<form class="row g-3" name="edit" action="Edit" method="post" onclick= 'EditvValidate()'>
					<div class="col-md-12">
						<label for="inputPassword4" class="form-label">party id</label> <input
							type="text" class="form-control" name="inputPartyId"
							value=<%=user.getId()%> readonly="readonly">
					</div>

					<div class="col-md-6">
						<label for="inputFirstName" class="form-label">First name</label>
						<input type="text" class="form-control" name="inputFristName"
							value=<%=user.getFirstName()%> aria-label="First name" required>
					</div>
					<div class="col-md-6">
						<label for="inputLastName" class="form-label">Last name</label> <input
							type="text" class="form-control" name="inputLastName"
							value=<%=user.getLastName()%> aria-label="Last name" required>
					</div>

					<div class="col-12">
						<label for="inputAddress" class="form-label">Address</label> <input
							type="text" class="form-control" name="inputAddress"
							value=<%=user.getAddress()%> required>
					</div>
					<div class="col-md-6">
						<label for="inputCity" class="form-label">City</label> <input
							type="text" class="form-control" name="inputCity"
							value=<%=user.getCity()%> required>
					</div>
					<div class="col-md-6">
						<label for="inputState" class="form-label">State</label> <input
							type="text" class="form-control" name="inputState"
							value=<%=user.getState()%> required>
					</div>
					<div class="col-md-6">
						<label for="inputZip" class="form-label">Zip</label> <input
							type="text" class="form-control" name="inputZip"
							value=<%=user.getZip()%> required>
					</div>
					<div class="col-md-6">
						<label for="inputcountry" class="form-label">Country</label> <input
							type="text" class="form-control" name="inputCountry"
							value=<%=user.getCountry()%> required>
					</div>
					<div class="col-md-6">
						<label for="inputPhone" class="form-label">Phone number</label> <input
							type="text" class="form-control" name="inputPhone"
							value=<%=user.getPhone()%> required>
					</div>
					<div class="col-md-6">
						<label for="inputEmail4" class="form-label">Email</label> <input
							type="email" class="form-control" name="inputEmail"
							value=<%=user.getEmail()%> required>
					</div>
					<div class="col-md-6">
						<label for="inputEmail4" class="form-label">Password</label> <input
							type="text" class="form-control" name="inputPassword"
							value=<%=user.getPassword()%> required>
					</div>

					<div class="col-12 text-center ">
						<button type="submit" class="btn btn-outline-success btn-md  my-2">Edit</button>
						<a href="Home" type="submit" class="btn btn-outline-success btn-md ms-2">Back</a>
					</div>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>