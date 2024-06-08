package com.parcial.katerin.app.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parcial.katerin.app.repository.ObservacionesProyectosRepository;
import com.parcial.katerin.app.variables.Observaciones_Proyectos;


@Controller
public class ObservacionesControlador {
	@Autowired
	private ObservacionesProyectosRepository observacionesProyectosRepository;

	@GetMapping("/lista_Observaciones.html")
	public String listarObservaciones(Model model) {
		List<Observaciones_Proyectos> listaObservaciones = observacionesProyectosRepository.findAll();
		model.addAttribute("listaObservaciones", listaObservaciones);
		return "lista_Observaciones";
	}

	@GetMapping("/formObservaciones.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("observaciones_Proyectos", new Observaciones_Proyectos());
		List<Observaciones_Proyectos> listaObservaciones = observacionesProyectosRepository.findAll();
		model.addAttribute("listaObservaciones", listaObservaciones);
		return "formObservaciones";
	}

	@PostMapping("/guardarObservaciones")
	public String guardarObservaciones(@ModelAttribute Observaciones_Proyectos observaciones_Proyectos) {
		observacionesProyectosRepository.save(observaciones_Proyectos);
		return "redirect:/lista_Observaciones.html";
	}

	@GetMapping("/Observaciones_Proyectos/editar/{id}")
	public String modificarCalificaciones(@PathVariable("id") Integer id, Model model) {
		Observaciones_Proyectos observaciones_Proyectos = observacionesProyectosRepository.findById(id).get();
		model.addAttribute("observaciones_Proyectos", observaciones_Proyectos);

		List<Observaciones_Proyectos> listaObservaciones = observacionesProyectosRepository.findAll();
		model.addAttribute("listaObservaciones", listaObservaciones);

		return "formObservaciones";
	}

	@GetMapping("/Observaciones_Proyectos/eliminar/{id}")
	public String eliminarObservaciones(@PathVariable("id") Integer id, Model model) {
		observacionesProyectosRepository.deleteById(id);
		return "redirect:/lista_Observaciones.html";
	}

	@GetMapping("/Observaciones_Proyectos/inicio")
	public String Inicio() {
		return "index.html";
	}
}
