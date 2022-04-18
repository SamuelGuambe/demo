package com.samuel.demo.Investigador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/investigador")
public class InvestigadorController {

    private final InvestigadorService investigadorService;

    @Autowired
    public InvestigadorController(InvestigadorService investigadorService) {
        this.investigadorService = investigadorService;
    }

    @GetMapping
    public List<Investigador> getIvestigador(){

        return investigadorService.getInvestigador();
    }
    @PostMapping
    public void registarNovoInvestigador(@RequestBody Investigador investigador){
        investigadorService.addNovoInvestigador(investigador);
    }
    @DeleteMapping(path = "{investigadorId}")
    public  void deleteInvestigador(@PathVariable("investigadorId") Long investigadorId){
        investigadorService.deleteInvestigador(investigadorId);
    }
}
