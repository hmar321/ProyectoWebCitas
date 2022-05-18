<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Usuarios"%>
<%@ page import="com.ies.baroja.Controller"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <title>Perfil</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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
        <li class="nav-item">
          <a class="nav-link" href="menuin.html">Men�</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="perfil.html">Perfil</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="usuarios.html">Usuarios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="paisesin.html">Paises</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="centrosin.html">Centros</a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="container mt-5">
    <div class="row">

      <div class="col-sm-4">
        <h2>Perfil</h2>
        <div class="card">
          <div class="card-body">
            <img class="card-img-top" src="images/perfil.png" alt="Perfil" style="width:100%">
            <h4 class="card-title">John Doe</h4>
            <table class="table table-bordered">
              <tbody>
				<%
				HttpSession sesion = request.getSession();
				Usuarios usuario = (Usuarios) sesion.getAttribute("jugador");
				out.println("<tr class='table-primary'>");
				out.println("<td>" + usuario.getNombre() +"</td>");
				out.println("</tr>");
				%>
			</tbody>
            </table>
            <a href="editarperfil.html" class="btn btn-primary">Editar</a>
          </div>
        </div>
      </div>

      <div class="col-sm-8">
        <h3 class="mt-4">Conoce a tu persona especial</h3>
        <ul class="nav nav-pills flex-column">
          <li class="nav-item">
            <a class="nav-link" href="buscar.html">Buscar pareja</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ucitas.html">Tus citas</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="addcita.html">A�adir cita</a>
          </li>
        </ul>
      </div>
    </div>
  </div>

  <div class="mt-5 p-4 bg-dark text-white text-center">
    <h2>Contacto</h2>
    <p>
      Empresa: Almaraz�s LovingAdvice<br>
      Direcci�n: Calle Loveless 9 1231 Nowhere<br>
      Tel�fono: (+12) 48 648 15 15. Email: alm@heartbreaker.es
    </p>
  </div>

</body>

</html>