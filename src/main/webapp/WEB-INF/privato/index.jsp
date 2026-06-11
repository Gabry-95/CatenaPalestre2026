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
<link href="/css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">

	<!-- Navigation-->
	<%@ include file="/WEB-INF/privato/navbarPrivato.jsp"%>
	
	<p>Palestra: <%= request.getSession().getAttribute("Palestra") %></p>

	
	<!-- Portfolio-->
	<section class="content-section" id="portfolio">
		<div class="container px-4 px-lg-5">
			<div class="content-section-heading text-center">
				<h2 class="mb-5">Funzionalita' Amministrazione</h2>
			</div>
			<div class="row gx-0">
				<div class="col-lg-6">
					<a class="portfolio-item" href="/privato/cliente/RichiediAggiungiCliente">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Aggiungi Cliente</div>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port3.jpg" alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="/privato/abbonamento/RichiediAggiungiAbbonamento">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Crea Abbonamento</div>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port6.jpg" alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="/privato/dipendenti/Dipendenti">
						<div class="caption">
							<div class="caption-content">
							 <div class="h1">Visualizza Personale</div> 
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port2.jpg" alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="/privato/abbonamento/DettagliAbbonamento">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Visualizza Dettagli Abbonamento</div>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port8.jpg" alt="..." />
					</a>
				</div>
				<div class="row gx-0">
				<div class="col-lg-6">
					<a class="portfolio-item" href="/privato/news/RichiediCreaNews">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">News</div>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port4.jpg" alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="/privato/corsi/RichiediCorsi">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Corsi</div>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port5.jpg" alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="/privato/dipendenti/RichiediAggiungiDipendente">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Aggiungi Personale</div>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port9.jpg" alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="/privato/corsi/RichiediCorsi">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Visualizza Utenti Seguiti da Personal Trainer</div>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port7.jpg" alt="..." />
					</a>
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
