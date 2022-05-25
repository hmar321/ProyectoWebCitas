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
 * Servlet que controla todos los formularios y aplica métodos en funcion de la
 * página desde la que llegan los datos
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
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");

			if (request.getParameter("nombre") != null) {
				altaUsuario(request, response);
			} else if (request.getParameter("email") != null) {
				loginUsuario(request, response);
			} else if (request.getParameter("buscaUsuario") != null) {
				// buscaJugador(request, response);
			} else if (request.getParameter("cerrar") != null) {
				cerrarSesion(request, response);
			} else {
				response.sendRedirect("index.html");
			}

		} catch (Exception ex) {
			System.out.println("Error en servlet");
			ex.printStackTrace();
			mostrarError(response, "Error");
		}
	}

	private static void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		response.sendRedirect("index.html");
		System.out.println("Sesión cerrada");
	}

	private static void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession sesion = request.getSession();
		String sEmail = request.getParameter("email");
		String sPwd = request.getParameter("contrasena");
		/*
		 * LinkedList<Usuarios> lista = Controller.getUsuarios(); //for (int i = 0; i <
		 * lista.size(); i++) { String baseEmail = lista.get(i).getEmail(); String
		 * basePwd = lista.get(i).getContrasena();
		 */
		// Buscamos el usuario en la base de datos con el metodo getUsuario del
		// Controller
		Usuarios usuario = Controller.getUsuario(sEmail);
		if (sEmail.equals(usuario.getEmail()) && sPwd.equals(usuario.getContrasena())
				&& sesion.getAttribute("usuario") == null) {

			// si coincide email y password y además no hay sesión iniciada
			sesion.setAttribute("usuario", usuario);
			// redirijo a página con información de login exitoso
			response.sendRedirect("perfil.jsp");
		} else {
			// lógica para login inválido
			mostrarError(response, "El usuario " + sEmail + " no tiene acceso");
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
				out.println("<!DOCTYPE html>\r\n"
						+ "<html lang=\"es\">\r\n"
						+ "\r\n"
						+ "<head>\r\n"
						+ "  <title>Perfil</title>\r\n"
						+ "  <meta charset=\"utf-8\">\r\n"
						+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
						+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
						+ "  <link rel=\"stylesheet\" href=\"css/interfaz.css\">\r\n"
						+ "</head>\r\n"
						+ "\r\n"
						+ "<body>\r\n"
						+ "\r\n"
						+ "  <div id=\"h_index\" class=\"p-5 bg-dark text-white text-center\">\r\n"
						+ "    <h1 class=\"texto-borde\">BuscoPareja</h1>\r\n"
						+ "    <h3 class=\"texto-borde\">Empieza algo real</h3>\r\n"
						+ "  </div>\r\n"
						+ "\r\n"
						+ "  <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\r\n"
						+ "    <div class=\"container-fluid\">\r\n"
						+ "    </div>\r\n"
						+ "  </nav>\r\n"
						+ "\r\n"
						+ "  <div class=\"container mt-5\">\r\n"
						+ "    <div class=\"row\">\r\n"
						+ "\r\n"
						+ "      <div class=\"col-sm-7\">\r\n"
						+ "        <h2 class=\"text-success\">Usuario añadido correctamente</h2>\r\n"
						+ "        <div class=\"card\">\r\n"
						+ "          <div class=\"card-body\">\r\n"
						+ "            <img class=\"card-img-top\" src=\"images/perfil.png\" alt=\"Perfil\" style=\"width:300px\">\r\n"
						+ "            <h4 class=\"card-title\">"+usuario.getNombre()+"</h4>\r\n"
						+ "            <table class=\"table table-bordered\">\r\n"
						+ "              <tbody>\r\n"
						+ "                <tr>\r\n"
						+ "                  <th>País</th>\r\n"
						+ "                  <td>"+usuario.getPais()+"</td>\r\n"
						+ "                </tr>\r\n"
						+ "                <tr>\r\n"
						+ "                  <th>Ciudad</th>\r\n"
						+ "                  <td>"+usuario.getCiudad()+"</td>\r\n"
						+ "                </tr>\r\n"
						+ "                <tr>\r\n"
						+ "                  <th>Dirección</th>\r\n"
						+ "                  <td>"+usuario.getDireccion()+"</td>\r\n"
						+ "                </tr>\r\n"
						+ "                <tr>\r\n"
						+ "                  <th>Sexo</th>\r\n"
						+ "                  <td>"+usuario.getSexo()+"</td>\r\n"
						+ "                </tr>\r\n"
						+ "                <tr>\r\n"
						+ "                  <th>Pareja</th>\r\n"
						+ "                  <td>"+usuario.getPareja()+"</td>\r\n"
						+ "                </tr>\r\n"
						+ "                <tr>\r\n"
						+ "                  <th>Email</th>\r\n"
						+ "                  <td>"+usuario.getEmail()+"</td>\r\n"
						+ "                </tr>\r\n"
						+ "              </tbody>\r\n"
						+ "            </table>\r\n"
						+ "            <a class=\"btn btn-primary\" href=\"login.html\">Continuar</a>\r\n"
						+ "          </div>\r\n"
						+ "        </div>\r\n"
						+ "      </div>\r\n"
						+ "    </div>\r\n"
						+ "  </div>\r\n"
						+ "\r\n"
						+ "  <div class=\"mt-5 p-4 bg-dark text-white text-center\">\r\n"
						+ "    <h2>Contacto</h2>\r\n"
						+ "    <p>\r\n"
						+ "      Empresa: Almaraz´s LovingAdvice<br>\r\n"
						+ "      Dirección: Calle Loveless 9 1231 Nowhere<br>\r\n"
						+ "      Teléfono: (+12) 48 648 15 15. Email: alm@heartbreaker.es\r\n"
						+ "    </p>\r\n"
						+ "  </div>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "\r\n"
						+ "</html>");
				out.close();
			} else {
				// Mostramos que se ha producido un error
				mostrarError(response, "No se ha insertado el usuario");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			mostrarError(response, "Error en servletRegistro");
		}
	}

	private static void mostrarError(HttpServletResponse response, String sMensaje) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>Página de Héctor</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error interno<h1>\n" + "<h2 class=\"text-danger\">" + sMensaje + "<h2>\n"
				+ "<img src=\"img/error.png\" class=\"rounded\" alt=\"error interno\">" + "</div></BODY></HTML>");
		out.close();
	}

}
