
package com.paws4home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/servicios")
public class ServiciosController {

   @GetMapping("/servicios")
     public String nuevaSugerencia(Model model) {
          model.addAttribute("servicios", "valor");
          return ("/servicios/servicios");//editar
     }
    
}
