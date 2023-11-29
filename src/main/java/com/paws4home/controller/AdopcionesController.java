
package com.paws4home.controller;

import com.paws4home.domain.Mascota;
import com.paws4home.domain.Adoptar;
import com.paws4home.domain.DarAdopcion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.paws4home.service.MascotaService;
import com.paws4home.service.AdoptarService;
import com.paws4home.service.DarAdopcionService;
import com.paws4home.service.FirebaseStorageService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/adopciones")
public class AdopcionesController {
    
    @Autowired
    private MascotaService mascotaService;
    
    @Autowired
    private AdoptarService adoptarService;
    
    @Autowired
    private DarAdopcionService darAdopcionService;
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    //retorna principal adopciones
    @RequestMapping("/principal")
    public String inicioAdoptar(Model model) {
        model.addAttribute("attribute", "value");
        return "/adopciones/principal";
    }
    
    //retorna pagina de mascotas adoptables
    @GetMapping("/mascotas")
    public String opcionesAdopcion(Model model){
        List<Mascota> mascotas= mascotaService.getMascotas();
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
  
    //metodo ingreso de mascotas al sistema
    @PostMapping("/guardar")
    public String guardaMascota(Mascota mascota,
            @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            mascotaService.save(mascota);
            mascota.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "DarAdopcion", 
                            mascota.getIdMascota()));
        }
        mascotaService.save(mascota);
        return "redirect:/adopciones/mascotas";
    }
    
    
    //metodo guarda solicitudes de dar mascotas en adopcion
    @PostMapping("/solicitud")
    public String darAdopcion(DarAdopcion solicitud,
            @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            darAdopcionService.save(solicitud);
            solicitud.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "DarAdopcion", 
                            solicitud.getIdFormulario()));
        }
        darAdopcionService.save(solicitud);
        return "redirect:/adopciones/mascotas";
    }
    
    @GetMapping("/eliminar/{idMascota}")
    public String eliminarMascota(Mascota mascota) {
        //si ingresa, elimina los formularios asociados a esa mascota y después elimina la mascota
        if (mascota != null) {
            List<Adoptar> listaAdoptar = adoptarService.findByMascotaId(mascota.getIdMascota());
            if (listaAdoptar != null && !listaAdoptar.isEmpty()) {
                for (Adoptar adoptar : listaAdoptar) {
                    adoptarService.delete(adoptar);
                }
            }
            mascotaService.delete(mascota);
        }
        return "redirect:/adopciones/mascotas";
    }
    
    //metodo retorna la vista de modifica
    @GetMapping("/modificar/{idMascota}")
    public String modificarMascota(Model model, Mascota mascota){
        Mascota mascotas = mascotaService.getMascota(mascota);
        model.addAttribute("mascota", mascotas);
        return "/adopciones/modifica";
    }
    
    
}
