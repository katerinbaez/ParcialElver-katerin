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

import com.parcial.katerin.app.repository.UsuariosRepository;
import com.parcial.katerin.app.variables.Usuarios;

@Controller
public class UsuariosControlador {

	@Autowired
	private UsuariosRepository usuariosRepository;

	@GetMapping("/lista_Usuarios.html")
	public String listarUsuarios(Model model) {
		List<Usuarios> listaUsuarios = usuariosRepository.findAll();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "lista_Usuarios";
	}

	@GetMapping("/formUsuarios.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("usuarios", new Usuarios());
		List<Usuarios> listaUsuarios = usuariosRepository.findAll();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "formUsuarios";
	}

	@PostMapping("/guardarUsuarios")
	public String guardarUsuarios(@ModelAttribute Usuarios usuarios) {
		usuariosRepository.save(usuarios);
		return "redirect:/lista_Usuarios.html";
	}

	@GetMapping("/Usuarios/editar/{id}")
	public String modificarUsuarios(@PathVariable("id") Integer id, Model model) {
		Usuarios usuarios = usuariosRepository.findById(id).get();
		model.addAttribute("usuarios", usuarios);

		List<Usuarios> listaUsuarios = usuariosRepository.findAll();
		model.addAttribute("listaUsuarios", listaUsuarios);

		return "formUsuarios";
	}

	@GetMapping("/Usuarios/eliminar/{id}")
	public String eliminarUsuarios(@PathVariable("id") Integer id, Model model) {
		usuariosRepository.deleteById(id);
		return "redirect:/lista_Usuarios.html";
	}

	@GetMapping("/Usuarios/inicio")
	public String Inicio() {
		return "index.html";
	}

	@GetMapping("/loginAdmin.html")
	public String mostrarLoginAdmin() {
		return "loginAdmin";
	}

	@PostMapping("/verificarCredenciales")
	public String verificarCredenciales(@RequestParam("usuario") String usuario,
			@RequestParam("contrasena") String contrasena) {
		if (usuario.equals("barney") && contrasena.equals("123")) {
			return "redirect:/adminstrador.html";
		} else {
			return "redirect:/loginAdmin.html?error";
		}
	}

	@GetMapping("/loginDirector.html")
	public String mostrarLoginDirector() {
		return "loginDirector";
	}

	@PostMapping("/verificarCredencialesDirector")
	public String verificarCredencialesDirector(@RequestParam("usuario") String usuario,
			@RequestParam("contrasena") String contrasena) {
		if (usuario.equals("esteban") && contrasena.equals("3456")) {
			return "redirect:/director.html";
		} else {
			return "redirect:/loginDirector.html?error";
		}
	}

	@GetMapping("/loginEst.html")
	public String mostrarLoginEst() {
		return "loginEst";
	}

	@PostMapping("/verificarCredencialesEst")
	public String verificarCredencialesEst(@RequestParam("usuario") String usuario,
			@RequestParam("contrasena") String contrasena) {
		if (usuario.equals("katerine08") && contrasena.equals("120")) {
			return "redirect:/estudiante.html";
		} else {
			return "redirect:/loginEst.html?error";
		}
	}

	@GetMapping("/loginEv.html")
	public String mostrarLoginEv() {
		return "loginEv";
	}

	@PostMapping("/verificarCredencialesEv")
	public String verificarCredencialesEv(@RequestParam("usuario") String usuario,
			@RequestParam("contrasena") String contrasena) {
		if (usuario.equals("estefania") && contrasena.equals("8520")) {
			return "redirect:/evaluador.html";
		} else {
			return "redirect:/loginEv.html?error";
		}
	}

	@GetMapping("/loginCoor.html")
	public String mostrarLoginCoordinacion() {
		return "loginCoor";
	}

	@PostMapping("/verificarCredencialesCoor")
	public String verificarCredencialesCoor(@RequestParam("usuario") String usuario,
			@RequestParam("contrasena") String contrasena) {
		if (usuario.equals("julian") && contrasena.equals("2024")) {
			return "redirect:/coordinador.html";
		} else {
			return "redirect:/loginCoor.html?error";
		}
	}
}
