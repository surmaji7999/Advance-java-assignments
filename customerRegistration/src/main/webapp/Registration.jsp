<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	function validate() {
		console.log("hii");
		console.log(event);
		 //event.preventDefault();
		
		/*  var name =      document.forms["RegForm"]["Name"];*/
		var firstName = document.forms["registration"]["inputFristName"].value;
		var lastName = document.forms["registration"]["inputLastName"].value;
		var address = document.forms["registration"]["inputAddress"].value;
		var city = document.forms["registration"]["inputCity"].value;
		var state = document.forms["registration"]["inputState"].value;
		var zip = document.forms["registration"]["inputZip"].value;
		var country = document.forms["registration"]["inputCountry"].value;
		var phone = document.forms["registration"]["inputPhone"].value;
		var email = document.forms["registration"]["inputPassword"].value;
		var password = document.forms["registration"]["inputPassword"].value;
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
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Registration page</title>
</head>
<body>

	<%@ include file="NavBar.jsp"%>
	<div class="container">
		<div class="card mt-5">
		<%@ include file="Massage.jsp" %>
			<div class="card-header text-light text-center"
				style="background-color: #198754;">
				<h3>Register here</h3>
				<i class="	fa fa-user-plus" style="font-size: 36px"></i>
			</div>

			<div class="card-body">


				<form class="row g-3" name ="registration" action ="registration"method = "post" onsubmit= "return validate()">
					<div class="row g-3">
						<div class="col">

							<label for="inputFirstName" class="form-label">First name</label>
							<input type="text" class="form-control" name="inputFristName"placeholder="First name"  required>
						</div>
						<div class="col">
							<label for="inputLastName" class="form-label">Last name</label>
							 <input type="text" class="form-control" name ="inputLastName"placeholder="Last name" required>
						</div>
					</div>
					<div class="col-12">
						<label for="inputAddress" class="form-label">Address</label> 
						<input type="text" class="form-control" name="inputAddress" placeholder="1234 Main St" required>
					</div>
					<div class="col-md-6">
						<label for="inputCity" class="form-label">City</label> 
						<input type="text" class="form-control" name="inputCity"placeholder="City" required>
					</div>
					<div class="col-md-4">
						<label for="inputState" class="form-label">State</label> 
						<input type="text" class="form-control" name="inputState"placeholder="State" required>
					</div>
					<div class="col-md-2">
						<label for="inputZip" class="form-label">Zip</label> 
						<input type="text" class="form-control" name="inputZip" placeholder="Zip" required>
					</div>
					<div class="col-md-6">
						<label for="inputcountry" class="form-label">Country</label>
						 <input type="text" class="form-control" name="inputCountry"placeholder="Country" required>
					</div>
					<div class="col-md-6">
						<label for="inputPhone" class="form-label">Phone number</label> 
						<input type="number " class="form-control" name="inputPhone"placeholder="Pnone number" required>
					</div>
					<div class="col-md-6">
						<label for="inputEmail4" class="form-label">Email</label> 
						<input type="email" class="form-control" name="inputEmail"placeholder="Email" required>
					</div>
					<div class="col-md-6">
						<label for="inputPassword4" class="form-label">Password</label>
						 <input type="password" class="form-control" name="inputPassword"placeholder="password" required>
					</div>
					<div class="col-12 text-center ">
						<button  type="submit"class="btn btn-outline-success" >Register</button>
					</div>

				</form>
			</div>
		</div>
	</div>

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
		crossorigin="anonymous">
	</script>
</body>
</html>