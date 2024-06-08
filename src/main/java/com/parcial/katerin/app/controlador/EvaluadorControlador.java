package com.parcial.katerin.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parcial.katerin.app.repository.AnteproyectosAprobRepository;
import com.parcial.katerin.app.repository.DocentesRepository;
import com.parcial.katerin.app.repository.EvaluadorRepository;
import com.parcial.katerin.app.variables.Anteproyectos_Aprobados;
import com.parcial.katerin.app.variables.Docente;
import com.parcial.katerin.app.variables.Evaluador;


@Controller
public class EvaluadorControlador {
	@Autowired
	private EvaluadorRepository evaluadorRepository;

	@Autowired
	private DocentesRepository docenteRepository;

	@Autowired
	private AnteproyectosAprobRepository anteproyectoAprobRepository;

	@GetMapping("/lista_Evaluador.html")
	public String listarEvaluador(Model model) {
		List<Evaluador> listaEvaluador = evaluadorRepository.findAll();
		model.addAttribute("listaEvaluador", listaEvaluador);
		return "lista_Evaluador";
	}

	@GetMapping("/evaluador.html")
	public String mostrarPaginaEvaluador() {
		return "evaluador";
	}

	@GetMapping("/verCalificacionEv.html")
	public String mostrarCalificacionEvaluador() {
		return "verCalificacionEv";
	}

	@GetMapping("/formatosEvaluador.html")
	public String mostrarFormatosEvaluador() {
		return "formatosEvaluador";
	}

	@GetMapping("/ConsultarCalendarioEv.html")
	public String mostrarCalendarioEvaluador() {
		return "consultarCalendarioEv";
	}

	@GetMapping("/formEvaluador.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("evaluador", new Evaluador());
		List<Docente> listaDocente = docenteRepository.findAll();
		model.addAttribute("listaDocente", listaDocente);
		List<Anteproyectos_Aprobados> listaAnteproyectosAprob = anteproyectoAprobRepository.findAll();
		model.addAttribute("listaAnteproyectosAprob", listaAnteproyectosAprob);
		return "formEvaluador";
	}

	@PostMapping("/guardarEvaluador")
	public String guardarEvaluador(@ModelAttribute Evaluador evaluador) {
		evaluadorRepository.save(evaluador);
		return "redirect:/lista_Evaluador.html";
	}

	@GetMapping("/Evaluador/editar/{id}")
	public String modificarEvaluador(@PathVariable("id") Integer id, Model model) {
		Evaluador evaluador = evaluadorRepository.findById(id).get();
		model.addAttribute("evaluador", evaluador);

		List<Docente> listaDocente = docenteRepository.findAll();
		model.addAttribute("listaDocente", listaDocente);
		List<Anteproyectos_Aprobados> listaAnteproyectosAprob = anteproyectoAprobRepository.findAll();
		model.addAttribute("listaAnteproyectosAprob", listaAnteproyectosAprob);

		return "formEvaluador";
	}

	@PostMapping("/asignar_evaluador_procesar")
	public String asignarEvaluadorProcesar(@RequestParam("proyectoTitulo") String proyectoTitulo,
			@RequestParam("evaluador") String evaluadorId) {
		Evaluador evaluador = new Evaluador();
		evaluador.setAnteproyecto(proyectoTitulo);
		evaluador.setEvaluador(evaluadorId);
		evaluadorRepository.save(evaluador);
		return "redirect:/lista_Evaluador.html";
	}

	@GetMapping("/Evaluador/eliminar/{id}")
	public String eliminarEvaluador(@PathVariable("id") Integer id, Model model) {
		evaluadorRepository.deleteById(id);
		return "redirect:/lista_Evaluador.html";
	}

	@GetMapping("/Evaluador/inicio")
	public String Inicio() {
		return "index.html";
	}

	@GetMapping("/asignar_evaluador")
	public String mostrarFormularioAsignarEvaluador(Model model) {
		List<Docente> listaDocente = docenteRepository.findAll();
		model.addAttribute("listaDocente", listaDocente);
		return "asignar_evaluador";
	}

}
