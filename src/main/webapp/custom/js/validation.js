$(document).ready(function() {

	$("#name_error").hide();
	$("#email_error").hide();
	$("#password_error").hide();
	$("#confirm_error").hide();
	$("#contact_error").hide();
	$("#radio_error").hide();
	$("#check_error").hide();
	$("#image_error").hide();
	$("#pincode_error").hide();
	$("#landmark_error").hide();
	$("#street_error").hide();
	$("#city_error").hide();
	$("#state_error").hide();
	$("#dob_error").hide();

	var name_error = false;
	var email_error = false;
	var password_error = false;
	var confirm_password_error = false;
	var contact_error = false;
	var radio_error = false;
	var check_error = false;
	var image_error = false;
	var pincode_error = false;
	var landmark_error = false;
	var street_error = false;
	var city_error = false;
	var state_error = false;
	var dob_error = false;




	$("#name").focusout(function() {
		$("#name_error").hide();
		$("#name").css("border-bottom", "none");
	});
	$("#name").keyup(function() {
		check_name();
	});
	$("#name").focus(function() {
		check_name();
	});

	$("#mail").focusout(function() {
		$("#email_error").hide();
		$("#mail").css("border-bottom", "none");
	});
	$("#mail").keyup(function() {
		check_email();
	});
	$("#mail").focus(function() {
		check_email();
	});

	$("#pwd").focusout(function() {
		$("#password_error").hide();
		$("#pwd").css("border-bottom", "none");
	});
	$("#pwd").keyup(function() {
		check_password();
	});
	$("#pwd").focus(function() {
		check_password();
	});

	$("#cpwd").focusout(function() {
		$("#confirm_password_error").hide();
		$("#cpwd").css("border-bottom", "none");
	});
	$("#cpwd").keyup(function() {
		check_confirm_password();
	});
	$("#cpwd").focus(function() {
		check_confirm_password();
	});

	$("#contact").focusout(function() {
		$("#contact_error").hide();
		$("#contact").css("border-bottom", "none");
	});
	$("#contact").keyup(function() {
		check_contact();
	});
	$("#contact").focus(function() {
		check_contact();
	});


	$('input[name="gender"]').change(function() {
		check_radio();
	});
	$('input[name="gender"]').focusout(function() {
		$("#radio_error").hide();
	});

	$('input[name="options"]').change(function() {
		check_checkbox();
	});
	$('input[name="options"]').focusout(function() {
		$("#check_error").hide();
	});

	$("#img").change(function() {
		check_file();
		img_preview(this);
	});
	$("#img").focusout(function() {
		$("#image_error").hide();
	});


	$("#street").focusout(function() {
		$("#street_error").hide();
		$("#street").css("border-bottom", "1px solid #ccc");
	});
	$("#street").keyup(function() {
		check_street();
	});
	$("#street").focus(function() {
		check_street();
	});

	$("#pincode").focusout(function() {
		$("#pincode_error").hide();
		$("#pincode").css("border-bottom", "1px solid #ccc");
	});
	$("#pincode").keyup(function() {
		check_pincode();
	});
	$("#pincode").focus(function() {
		check_pincode();
	});

	$("#landmark").focusout(function() {
		$("#landmark_error").hide();
		$("#landmark").css("border-bottom", "1px solid #ccc");
	});
	$("#landmark").keyup(function() {
		check_landmark();
	});
	$("#landmark").focus(function() {
		check_landmark();
	});

	$("#city").change(function() {
		check_city();
	});
	$("#city").focusout(function() {
		$("#city_error").hide();
	});

	$("#state").change(function() {
		check_state();
	});
	$("#state").focusout(function() {
		$("#state_error").hide();
	});

	$("#dob").change(function() {
		check_date();
	});
	$("#dob").focusout(function() {
		$("#dob_error").hide();
	});

	//functions for different field validations
	function check_name() {
		console.log("name method called...");
		var pattern = /^[a-zA-Z\s]+$/;
		var name = $("#name").val();
		if (name.length == 0) {
			$("#name_error").html("Name can not be empty!!").css("color", "red");;
			$("#name_error").show();
			$("#name").css("border-bottom", "4px solid #F90A0A");
			name_error = true;
		} else if (!pattern.test(name)) {
			$("#name_error").html("Should contain only Characters").css("color", "red");;
			$("#name_error").show();
			$("#name").css("border-bottom", "4px solid #F90A0A");
			name_error = true;
		} else {
			$("#name_error").hide();
			$("#name").css("border-bottom", "4px solid #34F458");
		}
	}


	function check_email() {
		var pattern = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var email = $("#mail").val();
		if (email.length == 0) {
			$("#email_error").html("Email can not be empty!!").css("color", "red");;
			$("#email_error").show();
			$("#mail").css("border-bottom", "4px solid #F90A0A");
			email_error = true;
		} else if (!pattern.test(email)) {
			$("#email_error").html("Invalid Email!!").css("color", "red");;
			$("#email_error").show();
			$("#mail").css("border-bottom", "4px solid #F90A0A");
			email_error = true;
		} else {
			$("#email_error").hide();
			$("#mail").css("border-bottom", "4px solid #34F458");
		}

	}
	function check_password() {
		var password_length = $("#pwd").val().length;
		if (password_length == 0) {
			$("#password_error").html("Password can not be empty!!").css("color", "red");;
			$("#password_error").show();
			$("#pwd").css("border-bottom", "4px solid #F90A0A");
			password_error = true;
		}
		else if (password_length < 8) {
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
		var password = $("#pwd").val();
		var retype_password = $("#cpwd").val();
		if (retype_password === '') {
			$("#confirm_password_error").html("confirm password can not be null!!").css("color", "red");
			$("#confirm_password_error").show();
			$("#cpwd").css("border-bottom", "4px solid #F90A0A");
			confirm_password_error = true;
		}

		else if (password !== retype_password) {
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
			$("#contact_error").html("contact can not be empty!!").css("color", "red");
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
		else {
			$("#radio_error").hide();
		}
	}

	function check_checkbox() {
		if ($("input:checkbox").filter(":checked").length == 0) {
			console.log("one must selected");
			$("#check_error").html("one input must be selected!!").css("color", "red");
			$("#check_error").show();
			check_error = true;
		} else {
			$("#check_error").hide();
		}
	}

	function check_file() {
		console.log("inside check file", $("#img").val());
		var file = $("#img").val();
		if (file === '') {
			$("#image_error").html("Please select file!!").css("color", "red");;
			$("#image_error").show();
			image_error = true;
		} else {

			//var fileType = file["type"];
			var fileType = file.split('.').pop().toLowerCase();
			//var validImageTypes = ["image/jpeg", "image/png", "image/jpg", "image/JPG", "image/JPEG", "image/PNG"];
			//console.log($.inArray(fileType, validImageTypes) == -1);
			if ($.inArray(fileType, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
				$("#image_error").html("Please select valid file!!").css("color", "red");;
				$("#image_error").show();
				image_error = true;
			}
		}
	}

	function img_preview(input) {
		if (input.files && input.files[0]) {
			var file = new FileReader();
			file.onload = function(e) {
				$("#image_preview").attr('src', e.target.result).css({"max-width": "170px" });
			}
			file.readAsDataURL(input.files[0]);
		}

	}

	function check_date() {

		var date = $("#dob").val();
		if (date.length == 0) {
			$("#dob_error").html("Date of Birth can not be empty!!").css("color", "red");;
			$("#dob_error").show();
			dob_error = true;
		} else {
			$("#dob_error").hide();
		}
	}



	// validation for pincode
	function check_pincode() {
		var pattern = /^[0-9]+$/;
		var pincode = $("#pincode").val();
		if (pincode.length == 0) {
			$("#pincode_error").html("pincode can not be empty!!").css("color", "red");;
			$("#pincode_error").show();
			$("#pincode").css("border-bottom", "4px solid #F90A0A");
			pincode_error = true;
		} else if (!pattern.test(pincode)) {
			$("#pincode_error").html("Pincode contain only numbers").css("color", "red");;
			$("#pincode_error").show();
			$("#pincode").css("border-bottom", "4px solid #F90A0A");
			pincode_error = true;
		} else {
			$("#pincode_error").hide();
			$("#pincode").css("border-bottom", "4px solid #34F458");
		}
	}

	function check_landmark() {
		var landmark = $("#landmark").val();
		if (landmark.length == 0) {
			$("#landmark_error").html("landmark can not be empty!!").css("color", "red");;
			$("#landmark_error").show();
			$("#landmark").css("border-bottom", "4px solid #F90A0A");
			landmark_error = true;
		} else {
			$("#landmark_error").hide();
			$("#landmark").css("border-bottom", "4px solid #34F458");
		}
	}

	function check_street() {
		var street = $("#street").val();
		if (street.length == 0) {
			$("#street_error").html("Street can not be empty!!").css("color", "red");;
			$("#street_error").show();
			$("#street").css("border-bottom", "4px solid #F90A0A");
			street_error = true;
		} else {
			$("#street_error").hide();
			$("#street").css("border-bottom", "4px solid #34F458");
		}
	}

	function check_state() {
		var state = $("#state").val();
		if (state == "0") {
			$("#state_error").html("Please select State!!").css("color", "red");
			$("#state_error").show();
			state_error = true;
		} else {
			$("#state_error").hide();
		}
	}

	function check_city() {
		var city = $("#city").val();
		if (city == "0") {
			$("#city_error").html("Please select City!!").css("color", "red");
			$("#city_error").show();
			city_error = true;
		} else {
			$("#city_error").hide();
		}
	}

	$("#registration_form").submit(function() {
		name_error = false;
		email_error = false;
		password_error = false;
		confirm_password_error = false;
		contact_error = false;
		radio_error = false;
		check_error = false;
		image_error = false;
		pincode_error = false;
		landmark_error = false;
		street_error = false;
		city_error = false;
		state_error = false;
		dob_error = false;



		check_name();
		check_email();
		check_password();
		check_confirm_password();
		check_contact();
		check_radio();
		check_checkbox();
		check_file();
		check_pincode();
		check_landmark();
		check_street();
		check_city();
		check_state();
		check_date();

		if (name_error === false && email_error === false && password_error === false && confirm_password_error === false && contact_error === false &&
			radio_error === false && check_error === false &&
			image_error === false && pincode_error === false && landmark_error === false && street_error === false && state_error === false && city_error === false && dob_error === false) {
			alert("Registration Successfull");
			return true;
		} else {
			alert("Please Fill the form Correctly");
			return false;
		}
	});
});