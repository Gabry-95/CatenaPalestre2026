<%@page import="it.pale.tweb.dao.beans.Corso"%>
<%@page import="java.util.Vector"%>
<%@page import="it.pale.tweb.dao.beans.Palestra"%>
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
<title>Aggiungi un Corso</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="/assets/img/logo.ico" />
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
<script src="/js/checkbox.js"></script>
</head>
<body id="page-top">

	<%
	Palestra p = (Palestra) request.getAttribute("Palestra"); //prendiamo la palestra dalla sessione
	Corso c = (Corso) request.getAttribute("corsi");

	String action = "AggiungiCorsi";
	String ID = "";
	String nome = "";
	String costo = "";
	String tipo = "";
	String testoButton = "Aggiungi";
	String readonly = "";

	if (c != null) {//sono nel caso modifica 
		action = "ModificaCorsi";
		ID = c.getId() + "";
		nome = c.getNome() + "";
		costo = c.getCosto() + "";
		tipo = c.getTipo() + "";
		testoButton = "Modifica";
		readonly = "readonly";
	}
	%>
	<!-- Navigation-->
	<%@ include file="/WEB-INF/privato/navbarPrivato.jsp"%>
	
	<%
	if (request.getParameter("errore") != null) {
	%>
		
		<%@ include file="/WEB-INF/errore.jsp"%>

	<%
	}
	%>
	
	<!-- Masthead-->
	<br>
	<div class="container d-flex align-items-center flex-column">

		<!-- Masthead Heading-->
		<h1 class="masthead-heading text-uppercase mb-0">Aggiungi un
			Corso</h1>
	</div>
	<br>
	<br>

	<div class="container text-dark">
		<form action="<%=action%>" method="post">
			<%
			if (c != null) {
			%>
			<input type="hidden" name="id" value="<%=ID%>" />
			<%
			}
			%>

			<div class="form-floating mb-3">
				<input class="form-control" id="nome" name="nome" type="text"
					placeholder="Inserisci nome" required
					value="<%=nome%>" /> <label for="nome">Nome</label>
			</div>

			<div class="form-floating mb-3">
				<input class="form-control" id="costo" name="costo" type="number"
					placeholder="Inserisci costo" required
					value="<%=costo%>" /> <label for="costo">Costo</label>

			</div>

			<div class="form-floating mb-3">
				<input class="form-control" id="tipo" name="tipo" type="text"
					placeholder="Inserisci tipo" required
					value="<%=tipo%>" /> <label for="tipo">Tipo</label>
			</div>

			<p></p>
			<!-- POST -->
			<a href="RichiediCorsi"><button class="btn btn-secondary btn-xl"
					id="submitButton" type="button">Annulla</button></a>
			<button class="btn btn-secondary btn-xl" id="submitButton"
				type="submit"><%=testoButton%></button>
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	
	<!-- Footer-->
	<%@ include file="/WEB-INF/footer.jsp"%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	
</body>
</html>
