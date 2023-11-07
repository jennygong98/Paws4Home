
package com.paws4home.controller;

import com.paws4home.domain.Mascota;
import com.paws4home.domain.Adoptar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.paws4home.service.MascotaService;
import com.paws4home.service.AdoptarService;

@Controller
@RequestMapping("/adopciones")
public class AdopcionesController {
    
    @Autowired
    private MascotaService mascotaService;
    
    @Autowired
    private AdoptarService adoptarService;
    
    //retorna principal adopciones
    @RequestMapping("/principal")
    public String inicioAdoptar(Model model) {
        model.addAttribute("attribute", "value");
        return "/adopciones/principal";
    }
    
    //retorna pagina de mascotas adoptables
    @GetMapping("/mascotas")
    public String opcionesAdopcion(Model model){
        List<Mascota> mascotas= mascotaService.getMascotas(true);
        model.addAttribute("mascotas", mascotas);
        return "/adopciones/mascotas";
    }
    
    //retorna nueva página para llenar formulario
    @GetMapping("nuevo/{idMascota}")
    public String nuevaVista(Mascota mascot, Model model){
        Mascota mascota= mascotaService.getMascota(mascot);
        model.addAttribute("mascota",mascota);
        return "/adopciones/formularioAdoptar";
    }
    
    
    @PostMapping("nuevo/finalizarAdopcion")
    public String adopcion(Adoptar adoptar){
        //guardar informacion de formulario
        adoptarService.save(adoptar);
        return "redirect:/adopciones/mascotas";
    }
  
}
