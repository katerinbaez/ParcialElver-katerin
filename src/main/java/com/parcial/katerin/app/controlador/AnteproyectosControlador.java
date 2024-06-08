package com.parcial.katerin.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parcial.katerin.app.repository.AnteproyectosRepository;
import com.parcial.katerin.app.variables.Anteproyectos;
import com.parcial.katerin.app.variables.Registros_Proyectos;



@Controller
public class AnteproyectosControlador {

	@Autowired
	private AnteproyectosRepository anteproyectosRepository;

	@GetMapping("/lista_Anteproyectos.html")
	public String listarAnteproyectos(Model model) {
		List<Anteproyectos> listaAnteproyectos = anteproyectosRepository.findAll();
		model.addAttribute("listaAnteproyectos", listaAnteproyectos);
		return "lista_Anteproyectos";
	}

	@GetMapping("/formAnteproyectos.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("anteproyectos", new Anteproyectos());
		return "formAnteproyectos";
	}

	@GetMapping("/subirAnteproyecto.html")
	public String mostrarFormularioAnteproyecto(Model model) {
		model.addAttribute("Registros_Proyectos", new Registros_Proyectos());
		model.addAttribute("anteproyectos", new Anteproyectos());
		return "subirAnteproyecto";
	}

	@PostMapping("/guardarAnteproyectos")
	public String guardarAnteproyectos(@ModelAttribute Anteproyectos anteproyectos) {
		anteproyectosRepository.save(anteproyectos);
		return "redirect:/lista_Anteproyectos.html";
	}

	@GetMapping("/Anteproyectos/editar/{id}")
	public String modificarAnteproyectos(@PathVariable("id") Integer id, Model model) {
		Anteproyectos anteproyectos = anteproyectosRepository.findById(id).get();
		model.addAttribute("anteproyectos", anteproyectos);
		return "formAnteproyectos";
	}

	@GetMapping("/Anteproyectos/eliminar/{id}")
	public String eliminarAnteproyectos(@PathVariable("id") Integer id, Model model) {
		anteproyectosRepository.deleteById(id);
		return "redirect:/lista_Anteproyectos.html";
	}

	@GetMapping("/Anteproyectos/inicio")
	public String Inicio() {
		return "index.html";
	}
}
