<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="it.pale.tweb.dao.beans.Palestra"%>
<%@page import="it.pale.tweb.dao.beans.PalestraDAO"%>
<%@page import="java.util.Vector"%>

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
<link href="css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">

	<%
	Vector<Palestra> palestre = (Vector<Palestra>)request.getAttribute("palestre");
	%>

	<!-- Navigation-->
	<%@ include file="/WEB-INF/navbar.jsp"%>

	<form action="/DettagliPalestra" method="post">
		<div class="custom-select-container ">
			<div class="container py-5 text-center ">
				<h2 class="mb-1">Visualizza Le Nostre Sedi</h2>
			</div>
			<select name="idPalestra" class="custom-select">
				<%
				for (Palestra p : palestre) {
				%>
				<option value="<%=p.getId()%>"><%=p.getCitta()%> ,
					<%=p.getVia()%>, <%=p.getCap()%>
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

	<!-- Footer-->
	<%@ include file="/WEB-INF/Footer.jsp"%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
