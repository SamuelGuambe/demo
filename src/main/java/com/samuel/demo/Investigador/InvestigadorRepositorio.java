package com.samuel.demo.Investigador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvestigadorRepositorio extends JpaRepository<Investigador, Long> {

    //@Query("SELECT i FROM Ivestigador i where i.email =?1")
    Optional<Investigador> findInvestigadorByEmail(String email);

}
