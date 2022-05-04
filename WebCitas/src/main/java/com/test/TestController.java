package com.test;

import java.util.LinkedList;

import com.ies.baroja.Controller;
import com.model.Usuarios;

public class TestController {

	public static void main(String[] args) {
		System.out.println("Inicio de TestController");
		LinkedList<Usuarios> listaUsuarios = Controller.getUsuarios();
		System.out.println("Total de usuarios="+listaUsuarios.size());
		System.out.println("Total de usuarios="+listaUsuarios.toString());
	}

}
