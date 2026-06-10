<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="it.pale.tweb.dao.beans.Corso"%>
<%@page import="it.pale.tweb.dao.beans.Abbonamento"%>
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
<title>Visualizza Dettagli Abbonamento</title>
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
<script src="/js/checkbox.js"></script>
</head>
<body id="page-top">

	<%
	Vector<Corso> corsiSeguiti = (Vector<Corso>)request.getAttribute("corsiSeguiti");
	Abbonamento a = (Abbonamento)request.getAttribute("abbonamento");
	Boolean scadenza=(Boolean)request.getAttribute("scadenza");
	%>

	<!-- Navigation-->
	<%@ include file="/WEB-INF/privato/navbarPrivato.jsp"%>
	
	<div class="container py-5 text-center">
		<h1 class="mb-1">Dettagli Abbonamento</h1>
	</div>
	
	<div class="container py-5">
		<form class="row g-3"
			action="/privato/abbonamento/DettagliAbbonamento" method="get">
			<div class="col-md-6">
				<label for="matricola" class="form-label" >Inserire Matricola
					Utente</label> <input type="text" class="form-control" name="matricola"
					required>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Cerca
					Matricola</button>
			</div>
		</form>
	</div>

	<%
	if (a != null) {
	%>

	<div class="container py-5">
		<div class="container py-3">
			<label for="fattura" class="form-label">Codice
				Fattura</label> <input type="text" class="form-control"
				value="<%=a.getFattura()%>" readonly>
		</div>
		<div class="container py-3">
			<label for="matricola" class="form-label" >Matricola
				Utente</label> <input type="text" class="form-control"
				value="<%=a.getCliente()%>" readonly>
		</div>
		<div class="container py-3">
			<label for="inputCity" class="form-label">Data Scadenza</label> <input
				type="date" class="form-control" value="<%=a.getDataScadenza()%>"
				readonly>
		</div>
		<div class="container py-3">
			<label for="inputState" class="form-label">Tipo Abbonamento</label> <input
				type="text" class="form-control" value="<%=a.getTipo()%>" readonly>
		</div>
		<div class="container py-3">
			<label for="inputState" class="form-label">Costo</label> <input
				type="text" class="form-control" value="<%=a.getCosto()%>" readonly>
		</div>
		<%
		if (a.getLimiteIngressi()!=null) {
		%>

		<div class="container py-3">
			<label for="inputState" class="form-label">Limite Ingressi</label> <input
				type="text" class="form-control" value="<%=a.getLimiteIngressi()%>"
				readonly>
		</div>
	<%
		}
		else if (!(corsiSeguiti.isEmpty())) {
	%>
		<div class="container py-3 text-center">
			<h3 class="mb-1">Corsi Seguiti</h3>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nome</th>
					<th scope="col">Tipo</th>
					<th scope="col">Costo</th>
					<th scope="col">ID Corso</th>
				</tr>
			</thead>
			<tbody>
				<%
				int k = 0;
				for (Corso c : corsiSeguiti) {
				%>
				<tr>
					<td><%=k + 1%></td>
					<td><%=c.getTipo()%></td>
					<td><%=c.getNome()%></td>
					<td><%=c.getCosto()%> €</td>
					<td><%=c.getId()%></td>
				</tr>
				<%
				k++;
				}
				%>
			</tbody>
		</table>
	<%
		}
	%>
	
	<%if(scadenza){ %>
	<div class="container py-5">
		<form class="row g-3"
			action="/privato/abbonamento/RinnovoAbbonamento" method="get">
			<div class="col-12">
				<button type="submit" class="btn btn-primary" name="fattura" value="<%=a.getFattura()%>">Rinnova Abbonamento</button>
			</div>
		</form>
	</div>
	<% } %>
	
	<%
	}
	%>
	</div>
	<br> <br> <br> <br>
	
	<!-- Footer-->
	<%@ include file="/WEB-INF/Footer.jsp"%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
