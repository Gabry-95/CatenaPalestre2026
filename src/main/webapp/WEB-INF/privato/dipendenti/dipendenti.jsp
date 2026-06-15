<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="it.pale.tweb.dao.beans.Istruttore_sala"%>
<%@page import="it.pale.tweb.dao.beans.Istruttore_corso"%>
<%@page import="it.pale.tweb.dao.beans.Personal_trainer"%>
<%@page import="it.pale.tweb.dao.beans.Personale_amministrativo"%>


<%@page import="java.util.Vector"%>
<%@page import="it.pale.tweb.dao.utils.Utils"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Lista Dipendenti</title>
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
</head>
<body id="page-top">

	<%
	Vector<Istruttore_sala> is= (Vector<Istruttore_sala>)request.getAttribute("is");
	Vector<Istruttore_corso> ic=(Vector<Istruttore_corso>)request.getAttribute("ic");
	Vector<Personal_trainer> pts = (Vector<Personal_trainer>)request.getAttribute("pt");
	Vector<Personale_amministrativo> pa=(Vector<Personale_amministrativo>) request.getAttribute("pa");
	%>

	<!-- Navigation-->
	<%@ include file="/WEB-INF/privato/navbarPrivato.jsp"%>

	<div class="container py-5">
		<h3 class="mb-1">Istruttori Di Sala</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Matricola</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Palestra</th>
					<th scope="col">Telefono</th>
				</tr>
			</thead>
			<tbody>
				<%
				int k=0;
				for (Istruttore_sala s: is) {
					k++;
				%>
				<tr>
					<td><%=k%></td>
					<td><%=s.getMatricola()%></td>
					<td><%=s.getNome()%></td>
					<td><%=s.getCognome()%></td>
					<td><%=s.getPalestra()%></td>
					<td><%=s.getTelefono()%></td>
				</tr>
				<%
					k++;
				}
				%>
			</tbody>
		</table>
	</div>

	<div class="container py-5">
		<h3 class="mb-1">Istruttori Di Corsi</h3>
		<table class="table table-striped">
			<thead>
				<tr>
				<th scope="col">#</th>
					<th scope="col">Matricola</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Palestra</th>
					<th scope="col">Telefono</th>
				</tr>
			</thead>
			<tbody>
				<%
				k=0;
				for (Istruttore_corso i: ic) {
					k++;
				%>
				<tr>
					<td><%=k%></td>
					<td><%=i.getMatricola()%></td>
					<td><%=i.getNome()%></td>
					<td><%=i.getCognome()%></td>
					<td><%=i.getPalestra()%></td>
					<td><%=i.getTelefono()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<div class="container py-5">
		<h3 class="mb-1">Personal Trainer</h3>
		<table class="table table-striped">
			<thead>
				<tr>
				<th scope="col">#</th>
					<th scope="col">Matricola</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Palestra</th>
					<th scope="col">Telefono</th>
				</tr>
			</thead>
			<tbody>
				<%
				k=0;
				for (Personal_trainer t: pts) {
					k++;
				%>
				<tr>
					<td><%=k%></td>
					<td><%=t.getMatricola()%></td>
					<td><%=t.getNome()%></td>
					<td><%=t.getCognome()%></td>
					<td><%=t.getPalestra()%></td>
					<td><%=t.getTelefono()%></td>
					<td>
						<form class="col-12" action="/privato/cliente/ClientiPT" method="get">
								<input type="hidden" name="pt" value="<%=t.getMatricola()%>">
								<button type="submit" class="btn btn-primary btn">Visualizza Utenti Seguiti</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<div class="container py-5">
		<h3 class="mb-1">Personale amministrativo</h3>
		<table class="table table-striped">
			<thead>
				<tr>
				<th scope="col">#</th>
					<th scope="col">Matricola</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Palestra</th>
					<th scope="col">Telefono</th>
				</tr>
			</thead>
			<tbody>
				<%
				k=0;
				for (Personale_amministrativo a: pa) {
					k++;
				%>
				<tr>
					<td><%=k%></td>
					<td><%=a.getMatricola()%></td>
					<td><%=a.getNome()%></td>
					<td><%=a.getCognome()%></td>
					<td><%=a.getPalestra()%></td>
					<td><%=a.getTelefono()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>



	<!-- Footer-->
	<%@ include file="/WEB-INF/footer.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
