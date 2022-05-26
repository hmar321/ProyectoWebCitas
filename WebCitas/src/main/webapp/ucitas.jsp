<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Usuarios"%>
<%@ page import="com.model.Citas"%>
<%@ page import="com.ies.baroja.Controller"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html lang="es">

<head>
<title>Citas</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/interfaz.css">
</head>

<body>

	<div id="h_index" class="p-5 bg-dark text-white text-center">
		<h1 class="texto-borde">BuscoPareja</h1>
		<h3 class="texto-borde">Empieza algo real</h3>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="menuin.jsp">Men�</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					href="perfil.jsp">Perfil</a></li>
				<li class="nav-item"><a class="nav-link" href="usuarios.jsp">Usuarios</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="paisesin.jsp">Pa�ses</a></li>
				<li class="nav-item"><a class="nav-link" href="centrosin.jsp">Centros</a></li>
			</ul>
		</div>
	</nav>

	<div class="container mt-5">
		<div class="row">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>Fecha y hora</th>
						<th>Estadp</th>
						<th>Usuario 1</th>
						<th>Usuario 2</th>
					</tr>
				</thead>
				<tbody>
					<%
					try {
						HttpSession sesion = request.getSession();
						Usuarios usuario = (Usuarios) sesion.getAttribute("usuario");
						LinkedList<Citas> lista = Controller.getCitas();
						for (int i = 0; i < lista.size(); i++) {
							if (usuario.getEmail() == lista.get(i).getEmail1() || usuario.getEmail() == lista.get(i).getEmail2()) {
								out.println("<td>" + lista.get(i).getFecha_hora() + "</td>");
								out.println("<td>" + lista.get(i).getFracaso() + "</td>");
								out.println("<td>" + lista.get(i).getEmail1() + "</td>");
								out.println("<td>" + lista.get(i).getEmail2() + "</td>");
								out.println("</tr>");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						response.sendRedirect("index.html");
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<div class="mt-5 p-4 bg-dark text-white text-center">
		<h2>Contacto</h2>
		<p>
			Empresa: Almaraz�s LovingAdvice<br> Direcci�n: Calle Loveless 9
			1231 Nowhere<br> Tel�fono: (+12) 48 648 15 15. Email:
			alm@heartbreaker.es
		</p>
	</div>

</body>

</html>