<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="it.pale.tweb.dao.beans.Palestra"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%
  
    Palestra p = (Palestra) request.getAttribute("Palestra"); 
%>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Crea News</title>
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

	<div class="container py-5">
		<div class="container px-4 px-lg-5 text-center">
			<h1 class="mb-1">Crea Una Nuova News</h1>
		</div>
		<form class="row g-3" action="/privato/news/CreaNews" method="post">

			<div class="mb-4">
				<label for="testo" class="form-label text-secondary">Contenuto
					della News</label>

				<textarea class="form-control" name="testo" rows="6"
					placeholder="Scrivi qui il testo esteso della notizia che gli utenti leggeranno..."
					style="resize: none; border-radius: 10px;" required></textarea>
			</div>

			<div class="col-12">
				<button type="submit" class="btn btn-primary">Crea</button>
			</div>
		</form>
	</div>

	<br>
	<br>
	<br>
	<br>
	<!-- Footer-->
	<%@ include file="/WEB-INF/Footer.jsp"%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>