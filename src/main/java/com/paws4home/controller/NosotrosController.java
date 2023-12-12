package com.paws4home.controller;

import com.paws4home.domain.Sugerencia;
import com.paws4home.service.SugerenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nosotros")
public class NosotrosController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @RequestMapping("/principal")
    public String inicioAdoptar(Model model) {
        model.addAttribute("attribute", "value");
        return "/nosotros/principal";
    }

    @GetMapping("/contactenos")
    public String contactenos(Model model) {
        model.addAttribute("contactenos", "valor");
        return "/nosotros/contactenos";//editar
    }
}
