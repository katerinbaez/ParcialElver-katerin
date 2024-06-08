package com.parcial.katerin.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.parcial.katerin.app.repository.DocentesRepository;
import com.parcial.katerin.app.variables.Docente;

import java.util.List;

@Controller
public class DocenteControlador {

	@Autowired
	private DocentesRepository docenteRepository;

	@GetMapping("/lista_Docentes.html")
	public String listarDocentes(Model model) {
		List<Docente> listaDocente = docenteRepository.findAll();
		model.addAttribute("listaDocente", listaDocente);
		return "lista_Docentes";
	}

	@GetMapping("/formDocente.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("docente", new Docente());
		List<Docente> listaDocente = docenteRepository.findAll();
		model.addAttribute("listaDocente", listaDocente);
		return "formDocente";
	}

	@PostMapping("/guardarDocente")
	public String guardarDocente(@ModelAttribute Docente docente) {
		docenteRepository.save(docente);
		return "redirect:/lista_Docentes.html";
	}

	@GetMapping("/Docente/editar/{id}")
	public String modificarDocente(@PathVariable("id") Integer id, Model model) {
		Docente docente = docenteRepository.findById(id).get();
		model.addAttribute("docente", docente);

		List<Docente> listaDocente = docenteRepository.findAll();
		model.addAttribute("listaDocente", listaDocente);

		return "formDocente";
	}

	@GetMapping("/Docente/eliminar/{id}")
	public String eliminarDocente(@PathVariable("id") Integer id, Model model) {
		docenteRepository.deleteById(id);
		return "redirect:/lista_Docentes.html";
	}

	@GetMapping("/inicio1")
	public String Inicio() {
		return "index.html";
	}
}
