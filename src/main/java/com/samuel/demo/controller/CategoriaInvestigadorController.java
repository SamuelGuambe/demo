package com.samuel.demo.controller;
import com.samuel.demo.modelo.CategoriaInvestigador;
import com.samuel.demo.repositorio.CategoriaInvestigadoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoriaInvestigadorController {
    //LISTAR CATEGORIAS
    @Autowired
    private CategoriaInvestigadoresRepo repo;


    @GetMapping("/categoriaInvestigadores")
    public String index(Model model){
        List<CategoriaInvestigador>categoriaInvestigadores=(List<CategoriaInvestigador>) repo.findAll();
        model.addAttribute("categoriaInvestigadores",categoriaInvestigadores);
        return "categoriaInvestigadores/index";
    }

//    ROTA PARA FORMULARIO NOVA CATEGORIAS
    @GetMapping("/categoriaInvestigadores/novo")
    public String novo(){
        return "categoriaInvestigadores/novo";
    }

    @PostMapping("/categoriaInvestigadores/criar")
    public String criar(CategoriaInvestigador categoriaInvestigador){
        repo.save(categoriaInvestigador);
        return "redirect:/categoriaInvestigadores";
    }

    @GetMapping("/categoriaInvestigadores/{id}")
    public String busca(@PathVariable int id, Model model){
        Optional<CategoriaInvestigador> categoI = repo.findById(id);
        try {
            model.addAttribute("categoriaInvestigador", categoI.get());
        }
        catch (Exception err){return "redirect:/categoriaInvestigadores";}

        return "/categoriaInvestigadores/editar";
    }


    @PostMapping("/categoriaInvestigadores/{id}/actualizar")
    public String actualizar(@PathVariable int id, CategoriaInvestigador categoriaInvestigador){
        if(!repo.existsById(id)){
            return "redirect:/categoriaInvestigadores";
        }
        repo.save(categoriaInvestigador);
        return "redirect:/categoriaInvestigadores";
    }


    @GetMapping("/categoriaInvestigadores/{id}/excluir")
    public String excluir(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/categoriaInvestigadores";
    }
}
