package com.ies.baroja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Usuarios;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/** 1- recogida de datos */
			Usuarios usuario = new Usuarios(request.getParameter("nombre"), request.getParameter("direccion"),
					request.getParameter("ciudad"), request.getParameter("pais"), request.getParameter("sexo"),
					request.getParameter("pareja"),request.getParameter("email"),request.getParameter("contrasena"));
			/** 2- Insertar Usuario en la base de datos */
			boolean bRes = Controller.insertarUsuarios(usuario);
			/** 3- Mostrar resultado por pantalla */
			if (bRes) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<HTML>\n" + "<HEAD><TITLE>Página de JAGD</TITLE>" + " <meta charset=\"utf-8\">\r\n"
						+ " <meta name=\"viewport\"content=\"width=device-width, initial-scale=1\">\r\n"
						+ " <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
						+ " <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
						+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
						+ "<h2 class=\"text-success\">Usuario insertado correctamente<h2>\n"
						+ "<ul class=\"list-group\"> \n" + " <LI class=\"list-group-item\">nombre: "
						+ usuario.getNombre() + "</li>\n" + " <LI class=\"list-group-item\">procedencia: "
						+ usuario.getDireccion() + "</li>\n" + "<LI class=\"list-group-item\">altura: "
						+ usuario.getCiudad() + "</li>\n" + " <LI class=\"list-group-item\">peso: " + usuario.getPais()
						+ "</li>\n" + " <LI class=\"list-group-item\">posicion: " + usuario.getSexo() + "</li>\n"
						+ " <LI class=\"list-group-item\">nombre_equipo: " + usuario.getPareja() + "</li>\n"
						+ "</UL>\n" + "</div></BODY></HTML>");
				out.close();
			} else {
				// Mostramos que se ha producido un error
				mostrarError(response);
			}
		} catch (Exception ex) {
			System.out.println("Error en servlet");
			ex.printStackTrace();
			mostrarError(response);
		}
	}

	private static void mostrarError(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>Página de JAGD</TITLE>" + "<meta charset=\"utf-8\">\r\n"
				+ " <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\r\n"
				+ " <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ " <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error al insertar el usuario<h1>\n"
				+ "<img src=\"img/error.jpg\" class=\"rounded\" alt=\"errorinterno\">" + "</div></BODY></HTML>");
		out.close();
	}

}
