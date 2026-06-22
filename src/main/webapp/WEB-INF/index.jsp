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
<title>Aurora Fitness</title>
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
	<%@ include file="/WEB-INF/navbar.jsp"%>
	<!-- Header-->
	<header class="masthead d-flex align-items-center">
		<div class="container px-4 px-lg-5 text-center">
			<h1 class="mb-1">Benvenuto su Aurora Fitness</h1>
			<h3 class="mb-5">
				<em>La tua catena di palestre di fiducia</em>
			</h3>
			<a class="btn btn-primary btn-xl" href="#about">Scopri di più</a>
		</div>
	</header>

	<!-- About-->
	<section class="content-section" id="about">
		<div class="container px-4 px-lg-5 text-center">
			<div class="row gx-4 gx-lg-5 align-items-center">

				<!-- Colonna testo (sinistra) -->
				<div class="hero-testo">
					<h2>Da più di 10 anni al vostro servizio in tutta Italia!</h2>
					<br>
					<p class="lead mb-5">Benvenuto in Aurora Fitness, la catena di
						palestre dove il tuo percorso di benessere trova una nuova luce.
						Nati con l'obiettivo di rivoluzionare il concetto tradizionale di
						allenamento, abbiamo creato uno spazio in cui l'energia incontra
						l'equilibrio.</p>
					<p class="lead mb-5">Il nome Aurora rappresenta la nostra
						filosofia: ogni giorno è una nuova opportunità per risvegliare il
						proprio potenziale, superare i propri limiti e rigenerarsi. Che tu
						sia un atleta esperto o stia muovendo i tuoi primi passi verso uno
						stile di vita più sano, qui troverai l'ambiente ideale per
						brillare.</p>
					<a class="btn btn-dark btn-xl" href="#servizi">Scopri i
						Nostri Servizi</a>
				</div>

				<!-- Colonna Carosello immagine (destra) -->
				<div id="carosello-1" class="carousel slide" data-bs-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="assets/img/carosello1/atleta.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="assets/img/carosello1/atleta2.jpg" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carosello-1" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carosello-1" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
		</div>
	</section>

	<!-- Carosello 2-->
	<section class="carosello" id="carosello-2">
		<div id="carouselExampleAutoplaying" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">

				<!-- SLIDE 1 -->
				<div class="carousel-item active">
					<img src="assets/img/carosello2/img1.jpg" class="d-block w-100" alt="...">
					<div class="custom-slide-content">
						<p class="text-secondary text-uppercase text-white">ALLENAMENTI
							MIRATI</p>
						<h1 class="slide-title text-uppercase text-white">
							PROGRAMMI PERSONALIZZATI <br> PER OGNI OBIETTIVO
						</h1>
					</div>
				</div>

				<!-- SLIDE 2 -->
				<div class="carousel-item">
					<img src="assets/img/carosello2/img2.jpg" class="d-block w-100" alt="...">
					<div class="custom-slide-content">
						<p class="slide-subtitle text-uppercase text-white">ATTREZZATURA
							AL TOP</p>
						<h1 class="slide-title text-uppercase text-white">AUMENTA LA
							TUA FORZA MASSIMA QUANDO TI ALLENI CON I PESI LIBERI</h1>
					</div>
				</div>

				<!-- SLIDE 3 -->
				<div class="carousel-item">
					<img src="assets/img/carosello2/img3.jpg" class="d-block w-100" alt="...">
					<div class="custom-slide-content">
						<p class="slide-subtitle text-uppercase text-white">PESI E
							MOLTO ALTRO</p>
						<h1 class="slide-title text-uppercase text-white">
							SCEGLI I CORSI OFFERTI <br> DALLA TUA PALESTRA DI FIDUCIA
						</h1>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</section>

	<!-- Servizi-->
	<section class="content-section" id="servizi">
	
		<%
		if (request.getParameter("errore") != null) {
		%>

		<%@ include file="/WEB-INF/errore.jsp"%>

		<%
		}
		%>

		<div class="container px-4 px-lg-5">
			<div class="content-section-heading text-center">
				<h3 class="text-secondary mb-0">Servizi</h3>
				<h2 class="mb-5">Esplora i nostri Servizi</h2>
			</div>
			<div class="row gx-0">
				<div class="col-lg-6">
					<a class="portfolio-item" href="Galleria">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Galleria</div>
								<p class="mb-0">Non credi a ciò che diciamo? Dai un occhiata
									tu stesso!</p>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port1.jpg"
						alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="Abbonamenti">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Abbonamenti</div>
								<p class="mb-0">Visualizza i nostri piani di abbonamento</p>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port2.jpg"
						alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="Palestre">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Cerca le nostre sedi</div>
								<p class="mb-0">Visualizza le informazioni e i servizi
									offerti dalla sede a te più comoda</p>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port3.jpg"
						alt="..." />
					</a>
				</div>
				<div class="col-lg-6">
					<a class="portfolio-item" href="Sponsor">
						<div class="caption">
							<div class="caption-content">
								<div class="h1">Sponsor</div>
								<p class="mb-0">Scopri tutte le offerte e le collaborazioni</p>
							</div>
						</div> <img class="img-fluid" src="assets/img/portfolio/port4.jpg"
						alt="..." />
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
