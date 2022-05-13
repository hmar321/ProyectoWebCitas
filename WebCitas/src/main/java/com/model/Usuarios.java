package com.model;

public class Usuarios {
	private String nombre;
	private String direccion;
	private String ciudad;
	private String pais;
	private String sexo;
	private String pareja;
	private String email;
	private String contrasena;
	

	/**
	 * @param nombre
	 * @param direccion
	 * @param ciudad
	 * @param pais
	 * @param sexo
	 * @param pareja
	 * @param email
	 * @param contrasena
	 */
	public Usuarios(String nombre, String direccion, String ciudad, String pais, String sexo, String pareja,
			String email, String contrasena) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
		this.sexo = sexo;
		this.pareja = pareja;
		this.email = email;
		this.contrasena = contrasena;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}


	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}


	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}


	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}


	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	/**
	 * @return the pareja
	 */
	public String getPareja() {
		return pareja;
	}


	/**
	 * @param pareja the pareja to set
	 */
	public void setPareja(String pareja) {
		this.pareja = pareja;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}


	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	/**
	 * @return the String
	 */
	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(nombre);
		sbResultado.append(" ");
		sbResultado.append(direccion);
		sbResultado.append(" ");
		sbResultado.append(ciudad);
		sbResultado.append(" ");
		sbResultado.append(pais);
		sbResultado.append(" ");
		sbResultado.append(sexo);
		sbResultado.append(" ");
		sbResultado.append(pareja);
		sbResultado.append(" ");
		sbResultado.append(email);
		sbResultado.append(" ");
		sbResultado.append(contrasena);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}

	
}
