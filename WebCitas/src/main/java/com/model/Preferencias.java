package com.model;

public class Preferencias {
	private String id_usuario;
	private String id_categoria;
	private String sinconizar;
	/**
	 * @param id_usuario
	 * @param id_categoria
	 * @param sinconizar
	 */
	public Preferencias(String id_usuario, String id_categoria, String sinconizar) {
		super();
		this.id_usuario = id_usuario;
		this.id_categoria = id_categoria;
		this.sinconizar = sinconizar;
	}
	/**
	 * @return the id_usuario
	 */
	public String getId_usuario() {
		return id_usuario;
	}
	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	/**
	 * @return the id_categoria
	 */
	public String getId_categoria() {
		return id_categoria;
	}
	/**
	 * @param id_categoria the id_categoria to set
	 */
	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}
	/**
	 * @return the sinconizar
	 */
	public String getSinconizar() {
		return sinconizar;
	}
	/**
	 * @param sinconizar the sinconizar to set
	 */
	public void setSinconizar(String sinconizar) {
		this.sinconizar = sinconizar;
	}
	/**
	 * @return the String
	 */
	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(id_usuario);
		sbResultado.append(" ");
		sbResultado.append(id_categoria);
		sbResultado.append(" ");
		sbResultado.append(sinconizar);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}
}
