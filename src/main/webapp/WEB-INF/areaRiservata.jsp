<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Area Riservata</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/logo.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Simple line icons-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css"
	rel="stylesheet" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">

	<!-- Navigation-->
	<%@ include file="/WEB-INF/navbar.jsp"%>

	<!--Login Page  -->
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
		integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
		crossorigin="anonymous">

	<section class="login bg-white">
		<div class="login_box">
			<div class="left">
				<div class="top_link"></div>
				<div class="contact">
					<form action="Login" method="post" style="width: 100%;"> 
						<h3>Area Riservata</h3>

						<div class="input-group-custom" style="position: relative;">
							<i class="fa-solid fa-user"
								style="position: absolute; left: 5px; top: 22px; color: #4f30677d;"></i>
							<input type="text" name=username placeholder="USERNAME"
								style="padding-left: 30px;">
							<div class="invalid-feedback" data-sb-feedback="name:required">Username
								errato.</div>
						</div>

						<div class="input-group-custom" style="position: relative;">
							<i class="fa-solid fa-lock"
								style="position: absolute; left: 5px; top: 22px; color: #4f30677d;"></i>
							<input type="password" name=password placeholder="PASSWORD"
								style="padding-left: 30px;">
							<div class="invalid-feedback" data-sb-feedback="name:required">Password
								errata.</div>
						</div>

						<button class="submit">Accedi</button>
					</form>
				</div>
			</div>
			<div class="right">
				<div class="right-text">
					<h2></h2>
					<h5></h5>
				</div>
				<div class="right-inductor">
					
				</div>
			</div>
		</div>
	</section>


	<!-- Footer-->
	<%@ include file="/WEB-INF/footer.jsp"%>





	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>



</html>