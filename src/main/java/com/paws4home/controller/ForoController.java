package com.paws4home.controller;

import com.paws4home.domain.Foro;
import com.paws4home.service.ForoService;
import com.paws4home.service.impl.FirebaseStorageServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foro")
public class ForoController {

     @Autowired
     private ForoService foroService;

     @GetMapping("/listadoForo")
     public String Inicio(Model model) {
          List<Foro> listadoForos = foroService.getForos(false);
          model.addAttribute("foros", listadoForos);
          model.addAttribute("totalForos", listadoForos.size());
          return "/foro/listadoForo";
     }

     @GetMapping("/nuevo")
     public String foroNuevo(Foro foro) {
          return "/foro/modifica";
     }

     @PostMapping("/guardar")
     public String foroGuardar(Foro foro) {
 
          foroService.save(foro);
          return "redirect:/foro/listadoForo";
     }

     @GetMapping("/eliminar/{idForo}")
     public String foroEliminar(Foro foro) {
          foroService.delete(foro);
          return "redirect:/foro/listadoForo";
     }

     @GetMapping("/modificar/{idForo}")
     public String foroModifica(Foro foro, Model model) {
          foro = foroService.getForo(foro);
          model.addAttribute("foro", foro);
          return "/foro/modifica";
     }
     
     
}
