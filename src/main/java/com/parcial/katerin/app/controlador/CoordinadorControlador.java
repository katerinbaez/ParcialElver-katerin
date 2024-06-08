package com.parcial.katerin.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parcial.katerin.app.repository.CoordinadorRepository;
import com.parcial.katerin.app.variables.Coordinador;



@Controller
public class CoordinadorControlador {
	@Autowired
	private CoordinadorRepository coordinadorRepository;

	@GetMapping("/lista_Coordinadores.html")
	public String listarCoordinadores(Model model) {
		List<Coordinador> listaCoordinadores = coordinadorRepository.findAll();
		model.addAttribute("listaCoordinadores", listaCoordinadores);
		return "lista_Coordinadores";
	}

	@GetMapping("/coordinador.html")
	public String mostrarPaginaDirector() {
		return "coordinador";
	}

	@GetMapping("/informeEstadoAlumnos.html")
	public String mostrarInformeAlum() {
		return "informeEstadoAlumnos";
	}

	@GetMapping("/formCoordinador.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("coordinador", new Coordinador());
		List<Coordinador> listaCoordinadores = coordinadorRepository.findAll();
		model.addAttribute("listaCoordinadores", listaCoordinadores);
		return "formCoordinador";
	}

	@PostMapping("/guardarCoordinador")
	public String guardarCoordinador(@ModelAttribute Coordinador coordinador) {
		coordinadorRepository.save(coordinador);
		return "redirect:/lista_Coordinadores.html";
	}

	@GetMapping("/Coordinador/editar/{id}")
	public String modificarCalificaciones(@PathVariable("id") Integer id, Model model) {
		Coordinador coordinador = coordinadorRepository.findById(id).get();
		model.addAttribute("coordinador", coordinador);

		List<Coordinador> listaCoordinadores = coordinadorRepository.findAll();
		model.addAttribute("listaCoordinadores", listaCoordinadores);

		return "formCoordinador";
	}

	@GetMapping("/Coordinador/eliminar/{id}")
	public String eliminarCoordinador(@PathVariable("id") Integer id, Model model) {
		coordinadorRepository.deleteById(id);
		return "redirect:/lista_Coordinadores.html";
	}

	@GetMapping("/inicio")
	public String Inicio() {
		return "index.html";
	}
}
