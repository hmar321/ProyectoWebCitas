package com.model;

public class Categorias {
	private String categoria_id;
	private String categoria;
	private String descripcion;
	private String n_usuarios;
	/**
	 * @param categoria_id
	 * @param categoria
	 * @param descripcion
	 * @param n_usuarios
	 */
	public Categorias(String categoria_id, String categoria, String descripcion, String n_usuarios) {
		this.categoria_id = categoria_id;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.n_usuarios = n_usuarios;
	}

	/**
	 * @param categoria
	 * @param descripcion
	 */
	public Categorias(String categoria, String descripcion) {
		this.categoria = categoria;
		this.descripcion = descripcion;
	}

	/**
	 * @return the categoria_id
	 */
	public String getCategoria_id() {
		return categoria_id;
	}

	/**
	 * @param categoria_id the categoria_id to set
	 */
	public void setCategoria_id(String categoria_id) {
		this.categoria_id = categoria_id;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	/**
	 * @return the String
	 */
	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(categoria_id);
		sbResultado.append(" ");
		sbResultado.append(categoria);
		sbResultado.append(" ");
		sbResultado.append(descripcion);
		sbResultado.append(" ");
		sbResultado.append(n_usuarios);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}
}
