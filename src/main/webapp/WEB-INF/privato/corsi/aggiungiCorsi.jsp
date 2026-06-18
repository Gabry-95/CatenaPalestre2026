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
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">

	<%
Palestra p = (Palestra) request.getAttribute("Palestra"); //prendiamo la palestra dalla sessione
int prossimoID = (int) request.getAttribute("prossimoID");


String action="AggiungiCorsi";  
String ID=prossimoID+"";
String nome="";
String costo="";
String tipo="";
String testoButton="Aggiungi";
String readonly="";

/* if (studente!=null){//sono nel caso modifica quindi
	action="Modifica"; 
	matricola=studente.getMatricola()+"";
	nome=studente.getNome();
	dataN=studente.getDataDiNascita().toString();
	testoButton="Modifica";
	readonly="readonly";
} */

%>
	<!-- Navigation-->
	<%@ include file="/WEB-INF/privato/navbarPrivato.jsp"%>

	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">

			<!-- Masthead Heading-->
			<h1 class="masthead-heading text-uppercase mb-0">Aggiungi un
				Corso</h1>
		</div>

		<div class="container text-dark">
			<form action="<%=action %>" method="post">
				<div class="form-floating mb-3">
					<input class="form-control" id="ID" name="ID" type="text"
						placeholder="Inserisci Id" data-sb-validations="required"
						value="<%= ID %>" readonly /> <label for="ID">Id</label>
				</div>

				<div class="form-floating mb-3">
					<input class="form-control" id="nome" name="nome" type="text"
						placeholder="Inserisci nome" data-sb-validations="required"
						value="<%=nome %>" /> <label for="nome">Nome</label>
				</div>

				<div class="form-floating mb-3">
					<input class="form-control" id="costo" name="costo" type="number"
						placeholder="Inserisci costo" data-sb-validations="required"
						value="<%=costo %>" /> <label for="costo">Costo</label>
						
				</div>

				<div class="form-floating mb-3">
					<input class="form-control" id="tipo" name="tipo" type="text"
						placeholder="Inserisci tipo" data-sb-validations="required"
						value="<%=tipo %>" /> <label for="tipo">Tipo</label>
				</div>

				<p></p>
				<!-- POST -->
				<a href="RichiediCorsi"><button class="btn btn-secondary btn-xl"
						id="submitButton" type="button">Annulla</button></a>
				<button class="btn btn-secondary btn-xl" id="submitButton"
					type="submit"><%= testoButton %></button>
		</form>
		</div>
	</header>
</body>
</html>
