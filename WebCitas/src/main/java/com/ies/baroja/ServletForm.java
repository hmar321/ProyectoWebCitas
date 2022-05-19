package com.ies.baroja;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			if (request.getParameter("nombre") != null) {
				altaUsuario(request, response);
			} else if (request.getParameter("email") != null) {
				loginUsuario(request, response);
			} else if (request.getParameter("buscaNombre") != null) {
				//buscaJugador(request, response);
			} else {
				cerrarSesion(request, response);
			}

		} catch (Exception ex) {
			System.out.println("Error en servlet");
			ex.printStackTrace();
			mostrarError(response, "Error al dar de alta al usuario");
		}
	}

	private static void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("mensaje", "Se ha cerrado la sesión.");
		response.sendRedirect("index.html");
	}
	
	private static void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession sesion = request.getSession();
		String sEmail = request.getParameter("email");
		String sPwd = request.getParameter("contrasena");
		LinkedList<Usuarios> lista = Controller.getUsuarios();
		// deberíamos buscar el usuario en la base de datos, pero
		// ponemos un ejemplo en el mismo código
		for (int i = 0; i < lista.size(); i++) {
			String baseEmail=lista.get(i).getEmail();
			String basePwd=lista.get(i).getContrasena();
			if (sEmail.equals(baseEmail) && sPwd.equals(basePwd) && sesion.getAttribute("email") == null) {/** esta mal*/
				Usuarios usuario=Controller.getUsuario(sEmail);
				// si coincide email y password y además no hay sesión iniciada
				sesion.setAttribute("usuario", usuario);
				// redirijo a página con información de login exitoso
				response.sendRedirect("perfil.jsp");
			} else {
				// lógica para login inválido
				mostrarError(response,"El usuario "+sEmail+" no tiene acceso");
			}
		}
		

	}
	
	private static void altaUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			/** 1- recogida de datos */
			Usuarios usuario = new Usuarios(request.getParameter("nombre"), request.getParameter("direccion"),
					request.getParameter("ciudad"), request.getParameter("pais"), request.getParameter("sexo"),
					request.getParameter("pareja"), request.getParameter("email"), request.getParameter("contrasena"));
			/** 2- Insertar Usuario en la base de datos */
			boolean bRes = Controller.insertar(usuario);
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
						+ "<div class=\"card\">\r\n" + "          <div class=\"card-body\">\r\n"
						+ "            <img class=\"card-img-top\" src=\"images/perfil.png\" alt=\"Perfil\" style=\"width:100%\">\r\n"
						+ "            <h4 class=\"card-title\">" + usuario.getNombre() + "</h4>\r\n"
						+ "            <table class=\"table table-bordered\">\r\n" + "              <tbody>\r\n"
						+ "                <tr>\r\n" + "                  <th>País</th>\r\n" + "                  <td>"
						+ usuario.getPais() + "</td>\r\n" + "                </tr>\r\n" + "                <tr>\r\n"
						+ "                  <th>Ciudad</th>\r\n" + "                  <td>" + usuario.getCiudad()
						+ "</td>\r\n" + "                </tr>\r\n" + "                <tr>\r\n"
						+ "                  <th>Dirección</th>\r\n" + "                  <td>" + usuario.getDireccion()
						+ "</td>\r\n" + "                </tr>\r\n" + "                <tr>\r\n"
						+ "                  <th>Sexo</th>\r\n" + "                  <td>" + usuario.getSexo()
						+ "</td>\r\n" + "                </tr>\r\n" + "                <tr>\r\n"
						+ "                  <th>Pareja</th>\r\n" + "                  <td>" + usuario.getPareja()
						+ "</td>\r\n" + "                </tr>\r\n" + "                <tr>\r\n"
						+ "                  <th>Email</th>\r\n" + "                  <td>" + usuario.getEmail()
						+ "</td>\r\n" + "                </tr>\r\n" + "              </tbody>\r\n"
						+ "            </table>\r\n"
						+ "            <a href=\"login.html\" class=\"btn btn-primary\">Continuar</a>\r\n"
						+ "          </div>\r\n" + "        </div>\n" + "</div></BODY></HTML>");
				out.close();
			} else {
				// Mostramos que se ha producido un error
				mostrarError(response,"No se ha insertado el usuario");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			mostrarError(response,"Error en servletRegistro");
		}
	}

	private static void mostrarError(HttpServletResponse response, String sMensaje) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>Página de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error interno<h1>\n" + "<h2 class=\"text-danger\">" + sMensaje + "<h2>\n"
				+ "<img src=\"img/error.jpg\" class=\"rounded\" alt=\"error interno\">" + "</div></BODY></HTML>");
		out.close();
	}

}
