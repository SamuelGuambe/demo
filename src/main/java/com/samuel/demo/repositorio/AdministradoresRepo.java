package com.samuel.demo.repositorio;

import com.samuel.demo.modelo.Administrador;
import org.springframework.data.repository.CrudRepository;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {

}
