function validate() {
	var firstName = document.registration.inputFristName.value;
	var lastName = document.registration.value;
	var address = document.registration.value;
	var city = document.registration.value;
	var state = document.registration.value;
	var zip = documentregistration.value;
	var country = document.registration.value;
	var phone = document.registration.value;
	var email = document.registrationinpu.value;
	var password = document.registration.value;


	if (firstName.value.trim() == "" || firstName.value.trim() < 3) {
		alert("please provide valide first name");
		return false;
	}


	if (lastName.value.trim() == "" || lastName.value.trim() < 3) {
		alert("please provide valide last name");
		return false;
	}

	if (address.value.trim() == "") {
		alert("please provide address");
		return false;
	}

	if (city.value.trim() == "" || city.value.trim() < 3) {
		alert("please provide valide city");
		return false;
	}

	if (zip.value.trim() == "" || zip.value.trim() < 6) {
		alert("please provide valide zip");
		return false;
	}

	if (state.value.trim() == "" || state.value.trim() < 3) {
		alert("please provide valide state");
		return false;
	}

	if (country.value.trim() == "" || country.value.trim() < 3) {
		alert("please provide valide country");
		return false;
	}

	if (phone.value.trim() == "" || (phone.value.trim() < 10 && phone.value.trim() > 10)) {
		alert("please provide valide phone number");
		return false;
	}
	if (email.value.trim() == "") {
		alert("please provide email");
		return false;
	}
	if (password.value.trim() == "" || passwors.value.trim() < 6) {
		alert("please provide 6 or more characters in password");
		return false;
	}
	return true;
}