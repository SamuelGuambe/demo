package com.samuel.demo.repositorio;

import com.samuel.demo.modelo.CategoriaInvestigador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaInvestigadoresRepo extends CrudRepository<CategoriaInvestigador, Integer> {

//@Query(value="select CASE WHEN cout(1) > 0  THEN 'true' ELSE 'false' END from mysql_investigador.administradores where id = :id", nativeQuery = true)
//public boolean exist(int id);

@Query(value="select * from mysql_investigador.categoriaInvestigadores where categoria = :categoria", nativeQuery = true)
public CategoriaInvestigador Login(String categoria);
}
