package com.parcial.katerin.app.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.parcial.katerin.app.repository.EstudianteRepository;
import com.parcial.katerin.app.variables.Estudiante;

import java.util.List;
import java.util.Optional;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@GetMapping("/lista_estudiantes.html")
	public String listarEstudiante(Model model) {
		List<Estudiante> listaEstudiante = estudianteRepository.findAll();
		model.addAttribute("listaEstudiante", listaEstudiante);
		return "lista_estudiantes";
	}

	@GetMapping("/estudiante.html")
	public String mostrarPaginaEstudiante() {
		return "estudiante";
	}

	@GetMapping("/formatosEstudiante.html")
	public String mostrarFormatosEstudiante() {
		return "formatosEstudiante";
	}

	@GetMapping("/formRegistrosPest.html")
	public String mostrarPaginaRAnteproyectos() {
		return "formRegistrosPest";
	}

	@GetMapping("/verCalificacionEst.html")
	public String mostrarPaginaCalificacionEst() {
		return "verCalificacionEst";
	}

	@GetMapping("/ConsultarCalendarioEst.html")
	public String mostrarCalendarioEstudiante() {
		return "consultarCalendarioEst";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Integer id) {
		Optional<Estudiante> estudiante = estudianteRepository.findById(id);
		if (estudiante.isPresent()) {
			return ResponseEntity.ok(estudiante.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/formEstudiante.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		List<Estudiante> listaEstudiante = estudianteRepository.findAll();
		model.addAttribute("listaEstudiante", listaEstudiante);
		return "formEstudiante";
	}

	@PostMapping("/guardarEstudiante")
	public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
		estudianteRepository.save(estudiante);
		return "redirect:/lista_estudiantes.html";
	}

	@GetMapping("/Estudiante/editar/{id}")
	public String modificarEstudiante(@PathVariable("id") Integer id, Model model) {
		Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
		if (estudiante != null) {
			model.addAttribute("estudiante", estudiante);
		}
		List<Estudiante> listaEstudiante = estudianteRepository.findAll();
		model.addAttribute("listaEstudiante", listaEstudiante);
		return "formEstudiante";
	}

	@GetMapping("/Estudiante/eliminar/{id}")
	public String eliminarEstudiante(@PathVariable("id") Integer id, Model model) {
		estudianteRepository.deleteById(id);
		return "redirect:/lista_estudiantes.html";
	}

	@GetMapping("/inicio2")
	public String Inicio() {
		return "index.html";
	}
}
