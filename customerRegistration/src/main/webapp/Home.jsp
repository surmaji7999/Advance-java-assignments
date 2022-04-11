<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	  rel="stylesheet"
	  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	  crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<%@ page import= "Dao.ConnectionProvider" import= "Dao.UserDao"
import ="entity.User" import ="java.util.ArrayList"%>
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
					<li class="nav-item"><a class="nav-link "aria-current="page" href="Login.jsp">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="Registration.jsp">Register </a></li>
					</ul>
					
				<ul class="navbar-nav mr-right">
				<li  class="nav-item"><a class="nav-link"><%= request.getAttribute("userId") %> </a></li>
				<li class="nav-item"><a class="nav-link" href="LogOut">Logout  </a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	<!-- nav bar end -->
	
	
<!-- table creation -->
 
<table  class="table table-striped">
  <thead>
    <tr>
      <th scope="col">PartyId</th>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Address</th>
      <th scope="col">City</th>
      <th scope="col">State</th>
      <th scope="col">Zip</th>
      <th scope="col">Country</th>
      <th scope="col">phone</th>
      <th scope="col">Email</th>
    </tr>
  </thead>
  <tbody>
    <tr>
  
      	
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </tbody>
</table>
		
</body>
</html>