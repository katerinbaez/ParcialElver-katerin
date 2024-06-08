package com.parcial.katerin.app.controlador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DirectorControlador {

	@GetMapping("/director.html")
	public String mostrarPaginaDirector() {
		return "director"; // Suponiendo que "director" es el nombre de la vista HTML correspondiente
	}

	@GetMapping("/formatosDirector.html")
	public String mostrarFormatosDirector() {
		return "formatosDirector"; // Nombre de la vista HTML correspondiente a formatosDirector.html
	}

	@GetMapping("/gestionarProyectos.html")
	public String mostrarGestionProyectos() {
		return "gestionarProyectos"; // Nombre de la vista HTML correspondiente a formatosDirector.html
	}

	@GetMapping("/aggDirectorAnt.html")
	public String mostrarFormAgg() {
		return "aggDirectorAnt"; // Nombre de la vista HTML correspondiente a formatosDirector.html
	}

	@GetMapping("/asignarEvaluador.html")
	public String mostrarAggEv() {
		return "asignarEvaluador"; // Nombre de la vista HTML correspondiente a formatosDirector.html
	}

	@GetMapping("/ConsultarCalendarioD.html")
	public String mostrarCalendarioDirector() {
		return "consultarCalendarioD"; // Nombre de la vista HTML correspondiente a formatosDirector.html
	}
}
