package com.model;

public class Citas {
	private String fecha_hora;
<<<<<<< HEAD
	private String centro;
=======
	private String centro_id;
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb
	private String email1;
	private String email2;
	
	
	/**
	 * @param fecha_hora
<<<<<<< HEAD
	 * @param centro
	 * @param email1
	 * @param email2
	 */
	public Citas(String fecha_hora, String centro, String email1, String email2) {
		this.fecha_hora = fecha_hora;
		this.centro = centro;
=======
	 * @param centro_id
	 * @param email1
	 * @param email2
	 */
	public Citas(String fecha_hora, String centro_id, String email1, String email2) {
		this.fecha_hora = fecha_hora;
		this.centro_id = centro_id;
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb
		this.email1 = email1;
		this.email2 = email2;
	}

<<<<<<< HEAD

=======
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb
	/**
	 * @return the fecha_hora
	 */
	public String getFecha_hora() {
		return fecha_hora;
	}


	/**
	 * @param fecha_hora the fecha_hora to set
	 */
	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}


	/**
	 * @return the centro
	 */
	public String getCentro() {
		return centro;
	}

<<<<<<< HEAD

	/**
	 * @param centro the centro to set
	 */
	public void setCentro(String centro) {
		this.centro = centro;
	}


=======
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb
	/**
	 * @return the email1
	 */
	public String getEmail1() {
		return email1;
	}


	/**
	 * @param email1 the email1 to set
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	/**
	 * @return the email2
	 */
	public String getEmail2() {
		return email2;
	}


	/**
	 * @param email2 the email2 to set
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	/**
	 * @return the String
	 */
	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(fecha_hora);
		sbResultado.append(" ");
<<<<<<< HEAD
		sbResultado.append(centro);
=======
		sbResultado.append(centro_id);
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb
		sbResultado.append(" ");
		sbResultado.append(email1);
		sbResultado.append(" ");
		sbResultado.append(email2);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}
}
