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
<title>Abbonamenti</title>
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
	       <%@ include file = "/WEB-INF/navbar.jsp" %>

	<!-- container piani di abbonamento -->
	<div class="container py-5">
		<div class="row justify-content-center g-4">
			<div class="container px-4 px-lg-5 text-center">
				<h1 class="mb-1">I nostri Piani di Abbonamento</h1>
			</div>
			<div class="col-md-4">
				<div class="pricing-card card h-100 p-4">
					<div class="card-body text-center">
						<h5 class="text-muted text-uppercase mb-3">Standard</h5>
						<h2 class="display-4 fw-bold mb-4">30€/Mese</h2>
						<p class="text-muted mb-4">Perfetto per chi vuole iniziare</p>
						<!-- Vantaggi -->
						<ul class="list-unstyled feature-list mb-4"
							style="color: rgb(0, 208, 2)">
							<li>
								<p>
									<i class="fa-solid fa-check"></i> Accesso a tutte le nostre
									sedi
								</p>
								<p>
									<i class="fa-solid fa-check"></i> Accesso Illimitato alla sala
									pesi
								</p>
							</li>
						</ul>
						<!-- Limiti -->
						<ul class="list-unstyled feature-list mb-4"
							style="color: rgb(255, 0, 0)">
							<li>
								<p>
									<i class="fa-solid fa-x"></i> Non puoi Accedere ai nostri Corsi
								</p>
								<p>
									<i class="fa-solid fa-x"></i> Limite di 3 ingressi settimanali
								</p>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="pricing-card card h-100">
					<span class="badge bg-primary popular-badge">Popular</span>
					<div class="card-body text-center">
						<h5 class="text-primary text-uppercase mb-3">Premium</h5>
						<h2 class="display-4 fw-bold mb-4">60€/Mese</h2>
						<p class="text-muted mb-4">Ideale per chi cerca un'esperienza
							completa</p>
						<!-- Vantaggi -->
						<ul class="list-unstyled feature-list mb-4"
							style="color: rgb(0, 208, 2)">
							<li>
								<p>
									<i class="fa-solid fa-check"></i> Accesso a tutte le nostre
									sedi
								</p>
								<p>
									<i class="fa-solid fa-check"></i> Accesso Illimitato alla sala
									pesi
								</p>
								<p>
									<i class="fa-solid fa-check"></i> 1 Corso gratis incluso nel
									piano di abbonamento
								</p>
								<p>
									<i class="fa-solid fa-check"></i> Nessun limite di ingressi
								</p>
							</li>
						</ul>

						<!-- Limiti -->
						<ul class="list-unstyled feature-list mb-4"
							style="color: rgb(255, 0, 0)">
							<li>
								<p>
									<i class="fa-solid fa-x"></i> Non puoi usufruire del Personal
									Trainer
								</p>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="pricing-card card h-100 p-4">
					<div class="card-body text-center">
						<h5 class="text-secondary text-uppercase mb-3">Gold</h5>
						<h2 class="display-4 fw-bold mb-4">90€/Mese</h2>
						<p class="text-muted mb-4">Per chi cerca il massimo grado di
							personalizzazione</p>
						<!-- Vantaggi -->
						<ul class="list-unstyled feature-list mb-4"
							style="color: rgb(0, 208, 2)">
							<li>
								<p>
									<i class="fa-solid fa-check"></i> Accesso a tutte le nostre
									sedi
								</p>
								<p>
									<i class="fa-solid fa-check"></i> Accesso Illimitato alla sala
									pesi
								</p>
								<p>
									<i class="fa-solid fa-check"></i> 1 Corso gratis incluso nel
									piano di abbonamento
								</p>
								<p>
									<i class="fa-solid fa-check"></i> Nessun limite di ingressi
								</p>
								<p>
									<i class="fa-solid fa-check"></i> Personal Trainer Incluso nel
									Piano di abbonamento
								</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<section class="content-section d-flex justify-content-center">
		<div class="alert alert-warning rounded-3 shadow-sm" role="alert">
			<strong>Attenzione:</strong> <a>A seguito di varie richieste ti
				informiamo che, qualora tu scelga di seguire più corsi, solo quello
				meno costoso fra essi sarà incluso nel tuo Piano di Abbonamento, gli
				altri dovranno essere pagati separatamente</a>
		</div>
	</section>

	<!-- Footer-->
	<%@ include file = "/WEB-INF/Footer.jsp" %>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
