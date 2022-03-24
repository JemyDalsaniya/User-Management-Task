<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password Form</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css" />
<!-- Fontawesome CSS CDN -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" href="custom/css/style.css" />
</head>
<body>
<body class="bg-info bg_custom_color">
	<div class="container">

		<div class="row justify-content-center wrapper" id="login-box">
			<div class="col-lg-10 my-auto myShadow">
				<div class="row">
					<div class="col-lg-7 bg-white p-4">
						<h1 class="text-center font-weight-bold text-primary">Forgot
							Your Password?</h1>
						<hr class="my-3" />
						<p class="lead text-center text-secondary">To reset your
							password, enter the registered e-mail adddress and set New
							Password!!</p>
						<form action="#" method="post" class="px-3" id="login-form">
							<div id="forgotAlert"></div>
							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"><i
										class="far fa-envelope fa-lg fa-fw"></i></span>
								</div>
								<input type="email" id="email" name="email"
									class="form-control rounded-0" placeholder="E-Mail" required />
							</div>
							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"><i
										class="fas fa-key fa-lg fa-fw"></i></span>
								</div>
								<input type="password" id="password" name="password"
									class="form-control rounded-0" minlength="5"
									placeholder="New Password" required autocomplete="off" />
							</div>
							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"><i
										class="fas fa-key fa-lg fa-fw"></i></span>
								</div>
								<input type="password" id="password" name="password"
									class="form-control rounded-0" minlength="5"
									placeholder="Confirm Password" required autocomplete="off" />
							</div>

							<div class="form-group">
								<input type="submit" id="forgot-btn" value="Reset Password"
									class="btn btn-primary btn-lg btn-block myBtn" />
							</div>
						</form>
					</div>
					<div
						class="col-lg-5 d-flex flex-column justify-content-center myColor p-4">
						<h1 class="text-center font-weight-bold text-white">Reset
							Password!</h1>
						<hr class="my-4 bg-light myHr" />
						<a href="Userlogin.jsp"
							class="btn btn-outline-light btn-lg font-weight-bolder myLinkBtn align-self-center"
							id="back-link">Back</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Login Form End -->

	</div>
	<!-- jQuery CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%-- 	<%@ include file="footer.jsp"%>
 --%></body>
</html>