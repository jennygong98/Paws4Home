
package com.paws4home.controller;

import com.paws4home.domain.Donacion;
import com.paws4home.service.DonacionService;
import com.paws4home.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/donaciones")
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Donacion> listadoDonaciones = donacionService.getDonaciones(false);
        model.addAttribute("donaciones", listadoDonaciones);
        model.addAttribute("totalDonaciones", listadoDonaciones.size());

        return "/donaciones/listado";
    }

    @GetMapping("/nuevo")
    public String donacionNuevo(Donacion donacion) {
        return "/donaciones/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")//generalmente por formularios
    public String donacionGuardar(Donacion donacion){
            donacionService.save(donacion);
            
        return "redirect:/adopciones/principal";
    }

    @GetMapping("/eliminar/{idDonacion}")
    public String donacionEliminar(Donacion donacion) {
        donacionService.delete(donacion);
        return "redirect:/donaciones/listado";
    }

    @GetMapping("/modificar/{idDonacion}")
    public String donacionModificar(Donacion donacion, Model model) {
        donacion = donacionService.getDonacion(donacion);
        model.addAttribute("donacion", donacion);
        return "/donaciones/modifica";
    }

}
