package com.parcial.katerin.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorControlador {

	@GetMapping("/adminstrador.html")
	public String mostrarPaginaAdministrador() {
		return "adminstrador"; // Suponiendo que "administrador" es el nombre de la vista HTML correspondiente
	}

}