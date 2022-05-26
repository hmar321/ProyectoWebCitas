package com.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Citas;
import com.model.Usuarios;

/**
 * Clase que centraliza los métodos de acceso a BBDD
 * 
 * @author JAGD
 * @since 27/05/2021
 */

public class ConexionBBDD {

	Connection conexion;
	int port = 3306;
	String host = "localhost";
	String db = "web_citas";
	String user = "root";
	String password = "";

	String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	public void conectar() throws SQLException {
		conexion = DriverManager.getConnection(url, user, password);
	}

	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
	}

	public ResultSet ejecutarConsulta(String sentencia) {
		ResultSet rsResultado = null;
		try {
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
			rsResultado = prepStatement.executeQuery();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		return rsResultado;
	}

	public int insertar(Usuarios usuario) throws SQLException {
		int iRes = 0;
		String sInsert = "insert into usuarios (Nombre, Direccion, 	Ciudad, Pais, sexo, Pareja, Email, Contrasena) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			System.out.println("Ejecutando: " + sInsert);
			System.out.println("datos: " + usuario);
			PreparedStatement prepStatement = conexion.prepareStatement(sInsert);
			prepStatement.setString(1, usuario.getNombre());
			prepStatement.setString(2, usuario.getDireccion());
			prepStatement.setString(3, usuario.getCiudad());
			prepStatement.setString(4, usuario.getPais());
			prepStatement.setString(5, usuario.getSexo());
			prepStatement.setString(6, usuario.getPareja());
			prepStatement.setString(7, usuario.getEmail());
			prepStatement.setString(8, usuario.getContrasena());
			iRes = prepStatement.executeUpdate();
		} catch (SQLException sqlex) {
			System.out.println("Error : " + sqlex.getMessage());
			sqlex.printStackTrace();
			throw sqlex;
		}
		return iRes;
	}
	
	public int insertar(Citas cita) throws SQLException {
		int iRes = 0;
		String sInsert = "INSERT INTO web_citas.citas (fech_hora,centro_id,id_u1,id_u2) VALUES (?, ?, ?, ?)";
		try {
			System.out.println("Ejecutando: " + sInsert);
			System.out.println("datos: " + cita);
			PreparedStatement prepStatement = conexion.prepareStatement(sInsert);
			prepStatement.setString(1, cita.getFecha_hora());
			prepStatement.setString(2, cita.getCentro_id());
			prepStatement.setString(3, cita.getEmail1());
			prepStatement.setString(4, cita.getEmail2());
			iRes = prepStatement.executeUpdate();
		} catch (SQLException sqlex) {
			System.out.println("Error : " + sqlex.getMessage());
			sqlex.printStackTrace();
			throw sqlex;
		}
		return iRes;
	}

}
