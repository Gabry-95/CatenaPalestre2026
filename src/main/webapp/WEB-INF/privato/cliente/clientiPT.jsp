<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="it.pale.tweb.dao.beans.Cliente"%>

<%@page import="java.util.Vector"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Lista Clienti Seguiti</title>
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
	Vector<Cliente> clientiSeguiti= (Vector<Cliente>)request.getAttribute("clientiSeguiti");
	%>

	<!-- Navigation-->
	<%@ include file="/WEB-INF/privato/navbarPrivato.jsp"%>

	<div class="container py-5">
		<h3 class="mb-1">Lista Clienti</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Matricola</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Telefono</th>
				</tr>
			</thead>
			<tbody>
				<%
				int k=0;
				for (Cliente c: clientiSeguiti) {
					k++;
				%>
				<tr>
					<td><%=k%></td>
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
	<!-- Footer-->
	<br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
	<%@ include file="/WEB-INF/footer.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
