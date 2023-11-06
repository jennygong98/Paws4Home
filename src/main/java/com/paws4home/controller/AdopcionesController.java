
package com.paws4home.controller;

import com.paws4home.domain.Adopciones;
import com.paws4home.service.AdopcionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adopciones")
public class AdopcionesController {
    
    @Autowired
    private AdopcionesService adopcionesService;
   
    
    //retorna principal adopciones
    @RequestMapping("/principal")
    public String inicioAdoptar(Model model) {
        model.addAttribute("attribute", "value");
        return "/adopciones/principal";
    }
    
    //retorna pagina de mascotas adoptables
    @GetMapping("/mascotas")
    public String opcionesAdopcion(Model model){
        List<Adopciones> adopciones= adopcionesService.getAdopciones();
        model.addAttribute("mascotas", adopciones);
        return "/adopciones/mascotas";
    }
    
   
  
}
