<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="it.pale.tweb.dao.beans.Corso"%>
<%@page import="it.pale.tweb.dao.beans.CorsoDAO"%>
<%@page import="java.util.Vector"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Aggiungi Abbonamento</title>
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
<link href="/css/styles.css"
	rel="stylesheet" />
<script src="/js/checkbox.js"></script>
</head>
<body id="page-top">

	<%
	Vector<Corso> corsi = (Vector<Corso>) request.getAttribute("corsi");
	%>

	<!-- Navigation-->
	<%@ include file="/WEB-INF/privato/navbarPrivato.jsp"%>

	<div class="container py-5">
		<div class="container px-4 px-lg-5 text-center">
			<h1 class="mb-1">Crea Un Nuovo Abbonamento</h1>
		</div>
		<form class="row g-3"
			action="/privato/abbonamento/AggiungiAbbonamento" method="get">
			<div class="col-md-6">
				<label for="fattura" class="form-label" required>Codice
					Fattura</label> <input type="text" class="form-control" name="fattura"
					required>
			</div>
			<div class="col-md-6">
				<label for="matricola" class="form-label" required>Matricola
					Utente</label> <input type="text" class="form-control" name="matricola"
					required>
			</div>
			<div class="col-md-4">
				<label for="tipo" class="form-label">Tipologia Abbonamento</label> <select
					name="tipo" class="form-select" id="tipo">
					<option selected value="Standard">Standard</option>
					<option value="Premium">Premium</option>
					<option value="Gold">Gold</option>
				</select>
			</div>
			<h3 class="mb-1">Seleziona Corsi</h3>
			<%
			for (Corso c : corsi) {
			%>
			<div class="form-check">
				<input class="form-check-input corso-checkbox" type="checkbox"
					name="corsi" value="<%=c.getId()%>"> <label
					class="form-check-label"> <%=c.getNome()%>
				</label>
			</div>
			<%
			}
			%>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Aggiungi
					Abbonamento</button>
			</div>
		</form>
	</div>

	<!-- Footer-->
	<%@ include file="/WEB-INF/Footer.jsp"%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
