package com.ies.baroja;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.model.Centros;
import com.model.Citas;
import com.model.Paises;
import com.model.Usuarios;
import com.mysql.jdbc.PreparedStatement;
import com.bbdd.ConexionBBDD;

/**
 * Clase que conecta el servlet con la base de datos
 * 
 * @author H?ctor
 * @since 27/04/2021
 */
public class Controller {
	private static String sConsultaUsuarios = "SELECT Nombre, Direccion,Ciudad,Pais,Sexo,Pareja,Email,Contrasena FROM usuarios;";
	private static String sConsultaPaises = "SELECT pais,n_usuarios FROM paises;";
	private static String sConsultaCentros = "SELECT cp,centro,direccion,ciudad,pais,web FROM centros;";
<<<<<<< HEAD
	private static String sConsultaCitas = "SELECT fech_hora,centro,email1,email2 FROM citas;";
=======
	private static String sConsultaCitas = "SELECT cita_id, fech_hora,centro_id,fracaso,id_persona1,id_persona2 FROM usuarios;";
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb

	/**
	 * Devolver lista de usuarios
	 * 
	 * @return
	 */
	public static LinkedList<Usuarios> getUsuarios() {
		// Objeto con la lista de usuarios
		LinkedList<Usuarios> listaUsuarios = new LinkedList<Usuarios>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaUsuarios);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					Usuarios usuario = new Usuarios(rsResultado.getString("Nombre"), rsResultado.getString("Direccion"),
							rsResultado.getString("Ciudad"), rsResultado.getString("Pais"),
							rsResultado.getString("Sexo"), rsResultado.getString("Pareja"),
							rsResultado.getString("Email"), rsResultado.getString("Contrasena"));
					// Lo insertamos en la lista
					listaUsuarios.add(usuario);

				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("N?mero de usuarios=" + listaUsuarios.size());
		} catch (SQLException sqlex) {
			System.out.println("Error conexi?n: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return listaUsuarios;
	}

	public static boolean insertar(Usuarios usuario) {
		boolean bRes = true;
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			int iRes = miConexion.insertar(usuario);
			System.out.println("Resultado controlador = " + iRes);
		} catch (SQLException sqlex) {
			bRes = false;
		} finally {
			miConexion.desconectar();
		}
		return bRes;
	}

	public static Usuarios getUsuario(String email) {
		// Objeto con la lista de jugadores
		Usuarios usuario = null;
		/** 1-conecar a la BBDD */
		ConexionBBDD miConexion = new ConexionBBDD();
		String sConsultaBuscaUsuario = "SELECT nombre, direccion, ciudad, pais,sexo,pareja,email,contrasena FROM usuarios WHERE email = '"
				+ email + "';";
		try {
			miConexion.conectar();
			/** 2-lanzar consulta */
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBuscaUsuario);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				/** 3-recuperar los datos */
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					usuario = new Usuarios(rsResultado.getString("nombre"), rsResultado.getString("direccion"),
							rsResultado.getString("ciudad"), rsResultado.getString("pais"),
							rsResultado.getString("sexo"), rsResultado.getString("pareja"),
							rsResultado.getString("email"), rsResultado.getString("contrasena"));
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
			/** 4-cerrar conexi?n */
		} finally {
			miConexion.desconectar();
		}
		return usuario;
	}

//----------------------------------------------------------------------Paises-----------------------------------------------------------------
	public static LinkedList<Paises> getPaises() {
		// Objeto con la lista de usuarios
		LinkedList<Paises> listaPaises = new LinkedList<Paises>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaPaises);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					Paises pais = new Paises(rsResultado.getString("pais"), rsResultado.getString("n_usuarios"));
					// Lo insertamos en la lista
					listaPaises.add(pais);

				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("N?mero de usuarios=" + listaPaises.size());
		} catch (SQLException sqlex) {
			System.out.println("Error conexi?n: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return listaPaises;
	}

//----------------------------------------------------------------------Centros---------------------------------------------------------------
	public static LinkedList<Centros> getCentros() {
		// Objeto con la lista de usuarios
		LinkedList<Centros> listaCentros = new LinkedList<Centros>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaCentros);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					Centros centro = new Centros(rsResultado.getString("cp"), rsResultado.getString("centro"),
							rsResultado.getString("direccion"), rsResultado.getString("ciudad"),
							rsResultado.getString("pais"), rsResultado.getString("web"));
					// Lo insertamos en la lista
					listaCentros.add(centro);

				}

			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("N?mero de usuarios=" + listaCentros.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return listaCentros;
	}

//----------------------------------------------------------------------Citas-----------------------------------------------------------------
	public static LinkedList<Citas> getCitasUsuario(Usuarios usuario) {
		// Objeto con la lista de usuarios
		LinkedList<Citas> listaCitas = new LinkedList<Citas>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		String sConsultaBuscaUsuario = "SELECT fech_hora, centro, email1, email2 FROM citas WHERE email1 = '"
				+ usuario.getEmail() + "' OR email2 = '"+usuario.getEmail() +"';";
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBuscaUsuario);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
<<<<<<< HEAD
					Citas cita = new Citas(rsResultado.getString("fech_hora"), rsResultado.getString("centro"),
							rsResultado.getString("email1"), rsResultado.getString("email2"));
					// Lo insertamos en la lista
					listaUsuarios.add(cita);
=======
					Citas cita = new Citas(rsResultado.getString("fech_hora"), rsResultado.getString("centro_id"),
							rsResultado.getString("id_persona1"), rsResultado.getString("id_persona1"));
					// Lo insertamos en la lista
					listaCitas.add(cita);
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb

				}

			} else {
				System.out.println("La consulta no devuelve resultados");
			}
<<<<<<< HEAD
			System.out.println("N?mero de citas del usuario=" + listaUsuarios.size());
=======
			System.out.println("N?mero de usuarios=" + listaCitas.size());
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return listaCitas;
	}

	public static boolean insertar(Citas cita) {
		boolean bRes = true;
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			int iRes = miConexion.insertar(cita);
			System.out.println("Resultado controlador = " + iRes);
		} catch (SQLException sqlex) {
			bRes = false;
		} finally {
			miConexion.desconectar();
		}
		return bRes;
	}

}