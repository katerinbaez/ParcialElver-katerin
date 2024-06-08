package com.parcial.katerin.app.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parcial.katerin.app.repository.RegistrosProyectosRepository;
import com.parcial.katerin.app.variables.Registros_Proyectos;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrosProyectosControlador {

	@Autowired
	private RegistrosProyectosRepository registrosProyectosRepository;

	@GetMapping("/lista_RegistrosProyectos.html")
	public String listarProyectosRegistrados(Model model) {
		List<Registros_Proyectos> listaRegProyectos = registrosProyectosRepository.findAll();
		model.addAttribute("listaRegProyectos", listaRegProyectos);
		return "lista_RegistrosProyectos";
	}

	@GetMapping("/formRegistrosP.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("registros_Proyectos", new Registros_Proyectos());
		return "formRegistrosP";
	}

	@PostMapping("/guardarRegistrosP")
	public String guardarRegistrosP(@ModelAttribute("registros_Proyectos") Registros_Proyectos registros_Proyectos) {
		registrosProyectosRepository.save(registros_Proyectos);
		return "redirect:/lista_RegistrosProyectos.html";
	}

	@GetMapping("/Registros_Proyectos/editar/{id}")
	public String modificarregistro(@PathVariable("id") Integer id, Model model) {
		Registros_Proyectos registros_Proyectos = registrosProyectosRepository.findById(id).orElse(null);
		if (registros_Proyectos != null) {
			model.addAttribute("registros_Proyectos", registros_Proyectos);
		}
		List<Registros_Proyectos> listaRegProyectos = registrosProyectosRepository.findAll();
		model.addAttribute("listaRegProyectos", listaRegProyectos);
		return "subirAnteproyecto";
	}

	@GetMapping("/Registros_Proyectos/eliminar/{id}")
	public String eliminarRegistroP(@PathVariable("id") Integer id) {
		registrosProyectosRepository.deleteById(id);
		return "redirect:/lista_RegistrosProyectos.html";
	}

	@GetMapping("/inicio4")
	public String Inicio() {
		return "director.html";
	}
}
