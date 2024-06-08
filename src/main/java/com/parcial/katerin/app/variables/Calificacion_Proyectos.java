package com.parcial.katerin.app.variables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Calificacion_Proyectos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String proyecto_titulo;
	private String calificacion_director;
	private String calificacion_Evaluador;

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

	public String getCalificacion_director() {
		return calificacion_director;
	}

	public void setCalificacion_director(String calificacion_director) {
		this.calificacion_director = calificacion_director;
	}

	public String getCalificacion_Evaluador() {
		return calificacion_Evaluador;
	}

	public void setCalificacion_Evaluador(String calificacion_Evaluador) {
		this.calificacion_Evaluador = calificacion_Evaluador;
	}

}
