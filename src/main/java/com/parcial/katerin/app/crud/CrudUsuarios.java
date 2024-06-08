package com.parcial.katerin.app.crud;

import org.springframework.data.repository.CrudRepository;

import com.parcial.katerin.app.variables.Usuarios;

public interface CrudUsuarios extends CrudRepository<Usuarios, Integer> {

}
