<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Usuarios"%>
<%@ page import="com.ies.baroja.Controller"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Listado de usuarios de la web de citas</title>
</head>
<body>
	<div class="container mt-3">
		<h1>Listado de usuarios</h1>
		<table class="table table-striped">
			<thead class="table-dark">
				<tr>
					<th>nombre</th>
					<th>procedencia</th>
					<th>altura</th>
					<th>peso</th>
					<th>posicion</th>
					<th>nombre_equipo</th>
				</tr>
			</thead>
			<tbody>
				<%
				LinkedList<Usuarios> lista = Controller.getUsuarios();
				for (int i = 0; i < lista.size(); i++) {
					if (i % 2 == 0) {
						out.println("<tr class='table-primary'>");
					} else {
						out.println("<tr class='table-success'>");
					}
					out.println("<td>" + lista.get(i).getNombre() + "</td>");
					out.println("<td>" + lista.get(i).getDireccion() + "</td>");
					out.println("<td>" + lista.get(i).getCiudad() + "</td>");
					out.println("<td>" + lista.get(i).getPais() + "</td>");
					out.println("<td>" + lista.get(i).getSexo() + "</td>");
					out.println("<td>" + lista.get(i).getPareja() + "</td>");
					out.println("<td>" + lista.get(i).getEmail() + "</td>");
					out.println("</tr>");
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>