package com.model;

public class Citas {
	private String id_cita;
	private String fecha_hora;
	private String centro_id;
	private String fracaso;
	private String email1;
	private String email2;
	
	/**
	 * @param id_cita
	 * @param fecha_hora
	 * @param centro_id
	 * @param fracaso
	 * @param email1
	 * @param email2
	 */
	public Citas(String id_cita, String fecha_hora, String centro_id, String fracaso, String email1, String email2) {
		this.id_cita = id_cita;
		this.fecha_hora = fecha_hora;
		this.centro_id = centro_id;
		this.fracaso = fracaso;
		this.email1 = email1;
		this.email2 = email2;
	}

	/**
	 * @return the id_cita
	 */
	public String getId_cita() {
		return id_cita;
	}

	/**
	 * @param id_cita the id_cita to set
	 */
	public void setId_cita(String id_cita) {
		this.id_cita = id_cita;
	}

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
	 * @return the centro_id
	 */
	public String getCentro_id() {
		return centro_id;
	}

	/**
	 * @param centro_id the centro_id to set
	 */
	public void setCentro_id(String centro_id) {
		this.centro_id = centro_id;
	}

	/**
	 * @return the fracaso
	 */
	public String getFracaso() {
		return fracaso;
	}

	/**
	 * @param fracaso the fracaso to set
	 */
	public void setFracaso(String fracaso) {
		this.fracaso = fracaso;
	}

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
		sbResultado.append(id_cita);
		sbResultado.append(" ");
		sbResultado.append(fecha_hora);
		sbResultado.append(" ");
		sbResultado.append(centro_id);
		sbResultado.append(" ");
		sbResultado.append(fracaso);
		sbResultado.append(" ");
		sbResultado.append(email1);
		sbResultado.append(" ");
		sbResultado.append(email2);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}
}
