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
@RequestMapping("/sugerencia") //buscar como se llamaba la ventana
public class SugerenciaController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Sugerencia> listadoSugerencia = sugerenciaService.getSugerencia(false);
        model.addAttribute("sugerencia", listadoSugerencia);
        return "/sugerencia/listado";
    }

    @GetMapping("/nuevo")
    public String sugerenciaNuevo(Sugerencia sugerencia) {
        return "/sugerencia/modifica";
    }

}
