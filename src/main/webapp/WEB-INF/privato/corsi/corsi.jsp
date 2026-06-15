<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="it.pale.tweb.dao.beans.Palestra"%>
<%@page import="it.pale.tweb.dao.beans.Corso"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%
  Palestra p = (Palestra) request.getAttribute("Palestra"); //creiamo un oggetto palestra che conterrà l'attributo Palestra della sessione
Vector<Corso> corsi= (Vector<Corso>) request.getAttribute("corsi");
%>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Corsi</title>
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
	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<!-- Masthead Avatar Image-->
			<img class="masthead-avatar mb-5" src="/assets/logo.png"  />
			<!--adatta la dimensione del logo, e scrivi "logo" non log  -->
			<!-- Masthead Heading-->
			<h1 class="masthead-heading text-uppercase mb-0">Gestisci I
				Corsi</h1>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon"></div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Masthead Subheading-->
			<p></p>
		</div>

			<div class="mb-3" style="text-align: left;">
			<p class="masthead-subheading font-weight-light mb-0 ">
			<form class="row g-3" action="/privato/corsi/Corsi" method="post"> 
				<a href="aggiungi.html">
					<button type="button" class="btn btn-secondary btn-lg">Aggiungi un corso</button>
				</a>

				</p>
		</div> 

		
		<div class="container align-items-center">
			<table class="table table-secondary table-hover">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nome</th>
						<th scope="col">Costo</th>
						<th scope="col">Tipo</th>
						<!-- <th scope="col"></th> -->
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Corso c : corsi) {
					%>
					<tr>
						<td><%=
							c.getId()
							%></td>
						<td><%= c.getNome() %></td>
						<td><%= c.getCosto()%></td>
						<td><%= c.getTipo()%></td>
						
				
						<%-- <td><a
							href="RichiediModifica?matricola=<%= c.getId()%>">
								<button type="button" class="btn btn-secondary btn-lg">Modifica</button>
						</a></td> --%>
						<td><a
							href="/privato/corsi/Corsi?id=<%= c.getId()%>">
								<button type="button" class="btn btn-secondary btn-lg">Elimina</button>
						</a></td>

					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			</form>
		</div>

</header>
		<!-- Footer-->
		<%@ include file="/WEB-INF/footer.jsp"%>

		<!-- Bootstrap core JS-->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
		<!-- Core theme JS-->
		<script src="js/scripts.js"></script>
</body>
</html>