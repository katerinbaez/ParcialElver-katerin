package com.parcial.katerin.app.variables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Observaciones_Proyectos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String proyecto_titulo;
	private String evaluador;
	private String observaciones;

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

	public String getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(String evaluador) {
		this.evaluador = evaluador;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
