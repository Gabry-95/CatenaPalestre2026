<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="java.util.Vector"%>
<%@page import="it.pale.tweb.dao.beans.Palestra"%>
<%@page import="it.pale.tweb.dao.beans.Corso"%>
<%@page import="it.pale.tweb.dao.beans.Cliente"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Visualizza Iscritti ai Corsi</title>
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
	Palestra p = (Palestra) request.getAttribute("Palestra");
	Vector<Corso> corsi = (Vector<Corso>) request.getAttribute("corsi");
	Vector<Cliente> cl = (Vector<Cliente>) request.getAttribute("clienti");
	Corso selected = (Corso) request.getAttribute("selected");
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

	<form action="/privato/corsi/IscrittiCorsi" method="get">
		<div class="custom-select-container ">
			<div class="container py-5 text-center ">
				<h2 class="mb-1">Seleziona un corso</h2>
			</div>
			<select name="id" class="custom-select">
				<%
				for (Corso c : corsi) {
				%>
				<option value="<%=c.getId()%>"
					<%if (selected != null && c.getId() == selected.getId()) {%>
					selected <%}%>>
					<%=c.getNome()%>
				</option>
				<%
				}
				%>
			</select>

		</div>
		
		<div class="text-center">
			<button class="btn btn-primary btn-xl" id="dettagli" type="submit">Visualizza
				Dettagli</button>
		</div>
				
	</form>

	<%
	if (cl != null) {
	%>

	<div class="container py-5">
		<h3 class="mb-1">Clienti Iscritti al corso</h3>
		<table class="table table-striped">
			<thead>
				<tr>

					<th scope="col">Matricola</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Telefono</th>
				</tr>
			</thead>
			<tbody>
				<%
				int k = 0;
				for (Cliente c : cl) {
					k++;
				%>
				<tr>

					<td><%=c.getMatricola()%></td>
					<td><%=c.getNome()%></td>
					<td><%=c.getCognome()%></td>
					<td><%=c.getTelefono()%></td>
				</tr>
				<%
				k++;
				}
				%>
			</tbody>
		</table>
	</div>

	<%
	}
	%>

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
