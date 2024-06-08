package com.parcial.katerin.app.variables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registros_Proyectos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String proyecto_titulo;
	private String estudiante1;
	private String estudiante2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProyecto_titulo() {
		return proyecto_titulo;
	}

	public void setProyecto_titulo(String proyecto_titulo) {
		this.proyecto_titulo = proyecto_titulo;
	}

	public String getEstudiante1() {
		return estudiante1;
	}

	public void setEstudiante1(String estudiante1) {
		this.estudiante1 = estudiante1;
	}

	public String getEstudiante2() {
		return estudiante2;
	}

	public void setEstudiante2(String estudiante2) {
		this.estudiante2 = estudiante2;
	}
}
