package com.model;

public class Paises {
	private String pais;
	private String n_usuarios;


	/**
	 * @param pais
	 * @param n_usuarios
	 */
	public Paises(String pais, String n_usuarios) {
		this.pais = pais;
		this.n_usuarios = n_usuarios;
	}
	
	/**
	 * @param pais
	 */
	public Paises(String pais) {
		this.pais = pais;
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
	 * @return the n_usuarios
	 */
	public String getN_usuarios() {
		return n_usuarios;
	}

	/**
	 * @param n_usuarios the n_usuarios to set
	 */
	public void setN_usuarios(String n_usuarios) {
		this.n_usuarios = n_usuarios;
	}

	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(pais);
		sbResultado.append(" ");
		sbResultado.append(n_usuarios);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}

}
