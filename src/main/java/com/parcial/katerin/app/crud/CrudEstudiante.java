package com.parcial.katerin.app.crud;

import org.springframework.data.repository.CrudRepository;

import com.parcial.katerin.app.variables.Estudiante;

public interface CrudEstudiante extends CrudRepository<Estudiante, Integer> {

}
