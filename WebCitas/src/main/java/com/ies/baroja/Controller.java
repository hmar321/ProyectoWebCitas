package com.ies.baroja;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.model.Citas;
import com.model.Usuarios;
import com.mysql.jdbc.PreparedStatement;
import com.bbdd.ConexionBBDD;

public class Controller {
	private static String sConsultaUsuarios = "SELECT Nombre, Direccion,Ciudad,Pais,Sexo,Pareja,Email,Contrasena FROM usuarios;";
	private static String sConsultaCitas = "SELECT cita_id, fech_hora,centro_id,fracaso,id_u1,id_u2 FROM usuarios;";

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
					Usuarios usuario = new Usuarios(rsResultado.getString("Nombre"),
							rsResultado.getString("Direccion"),rsResultado.getString("Ciudad"),
							rsResultado.getString("Pais"),rsResultado.getString("Sexo"),
							rsResultado.getString("Pareja"),rsResultado.getString("Email"),
							rsResultado.getString("Contrasena"));
					// Lo insertamos en la lista
					listaUsuarios.add(usuario);

				}

			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Número de usuarios=" + listaUsuarios.size());
		} catch (SQLException sqlex) {
			System.out.println("Error conexión: " + sqlex.getMessage());
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
	
	public static LinkedList<Citas> getCitas() {
		// Objeto con la lista de usuarios
		LinkedList<Citas> listaUsuarios = new LinkedList<Citas>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaCitas);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					Citas jugador = new Citas(rsResultado.getString("cita_id"),rsResultado.getString("fech_hora"),rsResultado.getString("centro_id"),
							rsResultado.getString("fracaso"),rsResultado.getString("id_u1"),
							rsResultado.getString("id_u2"));
					// Lo insertamos en la lista
					listaUsuarios.add(jugador);

				}

			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Número de usuarios=" + listaUsuarios.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return listaUsuarios;
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