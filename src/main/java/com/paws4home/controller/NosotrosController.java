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
@RequestMapping("/nosotros") //buscar como se llamaba la ventana
public class NosotrosController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @GetMapping("/listadoSugerencia")
    public String inicio(Model model) {
        List<Sugerencia> listadoSugerencia = sugerenciaService.getSugerencia(false);
        model.addAttribute("sugerencia", listadoSugerencia);
        return "/nosotros/listado";//editar
    }

    @GetMapping("/nuevoSugerencia")
    public String sugerenciaNuevo(Sugerencia sugerencia) {
        return "/nosotros/nuevo"; //editar
    }

}
