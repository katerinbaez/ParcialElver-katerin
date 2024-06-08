package com.parcial.katerin.app.variables;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evaluador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String anteproyecto;
	private String evaluador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnteproyecto() {
		return anteproyecto;
	}

	public void setAnteproyecto(String anteproyecto) {
		this.anteproyecto = anteproyecto;
	}

	public String getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(String evaluadorId) {
		this.evaluador = evaluadorId;
	}

}
