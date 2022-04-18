package com.samuel.demo.Investigador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class InvestigadorService {

    private final InvestigadorRepositorio investigadorRepositorio;

    @Autowired
    public InvestigadorService(InvestigadorRepositorio investigadorRepositorio) {
        this.investigadorRepositorio = investigadorRepositorio;
    }

    public List<Investigador> getInvestigador(){
       return investigadorRepositorio.findAll();
         }

    public void addNovoInvestigador(Investigador investigador) {
        Optional<Investigador> investigadorOptional = investigadorRepositorio.findInvestigadorByEmail(investigador.getEmail());
        if (investigadorOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        investigadorRepositorio.save(investigador);


    }

    public void deleteInvestigador(Long investigadorId) {
        boolean exists = investigadorRepositorio.existsById(investigadorId);
        if (!exists){
        throw new IllegalStateException("investigador com id " + investigadorId + "Nao exite");

        }
        investigadorRepositorio.deleteById(investigadorId);

    }
}
