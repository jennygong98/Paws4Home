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
public class NosotrosController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @RequestMapping("/nosotros")
    public String nuevaSugerencia(Model model) {
        model.addAttribute("sugerencia", "valor");
        return "/nosotros";//editar
    }



}
