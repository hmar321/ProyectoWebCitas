package com.model;

public class Citas {
	private String id_cita;
	private String fecha_hora;
	private String centro_id;
	private String fracaso;
	private String id_u1;
	private String id_u2;
	
	/**
	 * @param id_cita
	 * @param fecha_hora
	 * @param centro_id
	 * @param fracaso
	 * @param id_u1
	 * @param id_u2
	 */
	public Citas(String id_cita, String fecha_hora, String centro_id, String fracaso, String id_u1, String id_u2) {
		this.id_cita = id_cita;
		this.fecha_hora = fecha_hora;
		this.centro_id = centro_id;
		this.fracaso = fracaso;
		this.id_u1 = id_u1;
		this.id_u2 = id_u2;
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
	 * @return the id_u1
	 */
	public String getId_u1() {
		return id_u1;
	}

	/**
	 * @param id_u1 the id_u1 to set
	 */
	public void setId_u1(String id_u1) {
		this.id_u1 = id_u1;
	}

	/**
	 * @return the id_u2
	 */
	public String getId_u2() {
		return id_u2;
	}

	/**
	 * @param id_u2 the id_u2 to set
	 */
	public void setId_u2(String id_u2) {
		this.id_u2 = id_u2;
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
		sbResultado.append(id_u1);
		sbResultado.append(" ");
		sbResultado.append(id_u2);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}
}
