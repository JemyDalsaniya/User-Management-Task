$(document).ready(function() {

	$("#name_error").hide();
	$("#email_error").hide();
	$("#password_error").hide();
	$("#confirm_error").hide();
	$("#contact_error").hide();
	$("#radio_error").hide();

	var name_error = false;
	var email_error = false;
	var password_error = false;
	var confirm_password_error = false;
	var contact_error = false;
	var radio_error = false;

	$("#name").focusout(function() {
		check_name();
	});
	$("#mail").focusout(function() {
		check_email();
	});
	$("#pwd").focusout(function() {
		check_password();
	});
	$("#cpwd").focusout(function() {
		check_confirm_password();
	});
	$("#contact").focusout(function() {
		check_contact();
	});


	function check_name() {
		var pattern = /^[a-zA-Z]*$/;
		var name = $("#name").val();
		if (pattern.test(name) && name !== '') {
			$("#name_error").hide();
			$("#name").css("border-bottom", "4px solid #34F458");
		} else {
			$("#name_error").html("Should contain only Characters").css("color", "red");;
			$("#name_error").show();
			$("#name").css("border-bottom", "4px solid #F90A0A");
			name_error = true;
		}
	}

	function check_email() {
		var pattern = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var email = $("#mail").val();
		if (pattern.test(email) && email !== '') {
			$("#email_error").hide();
			$("#mail").css("border-bottom", "4px solid #34F458");
		} else {
			$("#email_error").html("Invalid Email").css("color", "red");;
			$("#email_error").show();
			$("#mail").css("border-bottom", "4px solid #F90A0A");
			email_error = true;
		}
	}
	function check_password() {
		var password_length = $("#pwd").val().length;
		if (password_length < 8) {
			$("#password_error").html("Atleast 8 Characters").css("color", "red");;
			$("#password_error").show();
			$("#pwd").css("border-bottom", "4px solid #F90A0A");
			password_error = true;
		} else {
			$("#password_error").hide();
			$("#pwd").css("border-bottom", "4px solid #34F458");
		}
	}

	function check_confirm_password() {
		var password = $("#cpwd").val();
		var retype_password = $("#cpwd").val();
		if (password !== retype_password) {
			$("#confirm_password_error").html("Passwords Did not Matched").css("color", "red");
			$("#confirm_password_error").show();
			$("#cpwd").css("border-bottom", "4px solid #F90A0A");
			confirm_password_error = true;
		} else {
			$("#confirm_password_error").hide();
			$("#cpwd").css("border-bottom", "4px solid #34F458");
		}
	}

	function check_contact() {
		var contact_pattern = /([0-9]{10})|(\([0-9]{3}\)\s+[0-9]{3}\-[0-9]{4})/;
		var contact = $("#contact").val();
		var contact_length = $("#contact").val().length;
		if (contact === '') {
			$("#contact_error").html("contact can not be null!!").css("color", "red");
			$("#contact_error").show();
			$("#contact").css("border-bottom", "4px solid #F90A0A");
			contact_error = true;

		}
		else if (contact_length < 10 || contact_length > 10) {
			$("#contact_error").html("only 10 digits are allowed!!").css("color", "red");;
			$("#contact_error").show();
			$("#contact").css("border-bottom", "4px solid #F90A0A");
			contact_error = true;
		} else if (!contact_pattern.test(contact)) {
			$("#contact_error").html("only digits are allowed!!").css("color", "red");
			$("#contact_error").show();
			$("#contact").css("border-bottom", "4px solid #F90A0A");
			contact_error = true;
		}
		else {
			$("#contact_error").hide();
			$("#contact").css("border-bottom", "4px solid #34F458");
		}

	}
	function check_radio() {
		if ($('input[name="gender"]:checked').length == 0) {
			console.log("one must selected");
			$("#radio_error").html("one input must be selected!!").css("color", "red");
			$("#radio_error").show();
			radio_error = true;

		}
	}


	$("#registration_form").submit(function() {
		name_error = false;
		email_error = false;
		password_error = false;
		confirm_password_error = false;
		contact_error = false;
		radio_error = false;

		check_name();
		check_email();
		check_password();
		check_confirm_password();
		check_contact();
		check_radio();

		if (name_error === false && email_error === false && password_error === false && confirm_password_error === false && contact_error === false && radio_error === false) {
			alert("Registration Successfull");
			return true;
		} else {
			alert("Please Fill the form Correctly");
			return false;
		}
	});
});