package com.model;

public class Centros {
	private String cp;
	private String centro;
	private String direccion;
	private String ciudad;
	private String pais;
	private String web;
	/**
	 * @param cp
	 * @param centro
	 * @param direccion
	 * @param ciudad
	 * @param pais
	 * @param web
	 */
	public Centros(String cp, String centro, String direccion, String ciudad, String pais, String web) {
		this.cp = cp;
		this.centro = centro;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
		this.web = web;
	}
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	/**
	 * @return the centro
	 */
	public String getCentro() {
		return centro;
	}
	/**
	 * @param centro the centro to set
	 */
	public void setCentro(String centro) {
		this.centro = centro;
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
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}
	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	/**
	 * @return the String
	 */
	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(cp);
		sbResultado.append(" ");
		sbResultado.append(centro);
		sbResultado.append(" ");
		sbResultado.append(direccion);
		sbResultado.append(" ");
		sbResultado.append(ciudad);
		sbResultado.append(" ");
		sbResultado.append(pais);
		sbResultado.append(" ");
		sbResultado.append(web);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}
}
