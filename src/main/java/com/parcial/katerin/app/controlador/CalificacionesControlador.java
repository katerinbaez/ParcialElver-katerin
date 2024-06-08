package com.parcial.katerin.app.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parcial.katerin.app.repository.CalificacionProyectosRepository;
import com.parcial.katerin.app.variables.Calificacion_Proyectos;



@Controller
public class CalificacionesControlador {

	@Autowired
	private CalificacionProyectosRepository calificacionProyectosRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/lista_Calificaciones.html")
	public String listarCalificaciones(Model model) {
		List<Calificacion_Proyectos> listaCalificaciones = calificacionProyectosRepository.findAll();
		model.addAttribute("listaCalificaciones", listaCalificaciones);
		return "lista_Calificaciones";
	}

	@GetMapping("/formCalificaciones.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("calificacion_Proyectos", new Calificacion_Proyectos());
		List<Calificacion_Proyectos> listaCalificaciones = calificacionProyectosRepository.findAll();
		model.addAttribute("listaCalificaciones", listaCalificaciones);
		return "formCalificaciones";
	}

	@GetMapping("/calificacionEvaluador.html")
	public List<Map<String, Object>> obtenerCalificaciones() {
		String consultaSQL = "SELECT proyecto_titulo, calificacion_Director, calificacion_Evaluador FROM calificacion_proyectos";
		return jdbcTemplate.queryForList(consultaSQL);
	}

	@PostMapping("/guardarCalificaciones")
	public String guardarCalificaciones(@ModelAttribute Calificacion_Proyectos calificacion_Proyectos) {
		calificacionProyectosRepository.save(calificacion_Proyectos);
		return "redirect:/lista_Calificaciones.html";
	}

	@GetMapping("/Calificacion_Proyectos/editar/{id}")
	public String modificarCalificaciones(@PathVariable("id") Integer id, Model model) {
		Calificacion_Proyectos calificacion_Proyectos = calificacionProyectosRepository.findById(id).orElse(null);
		model.addAttribute("calificacion_Proyectos", calificacion_Proyectos);

		List<Calificacion_Proyectos> listaCalificaciones = calificacionProyectosRepository.findAll();
		model.addAttribute("listaCalificaciones", listaCalificaciones);

		return "formCalificaciones";
	}

	@GetMapping("/Calificacion_Proyectos/eliminar/{id}")
	public String eliminarCalificaciones(@PathVariable("id") Integer id, Model model) {
		calificacionProyectosRepository.deleteById(id);
		return "redirect:/lista_Calificaciones.html";
	}

	@GetMapping("/Calificacion_Proyectos/inicio")
	public String Inicio() {
		return "index.html";
	}
}
