
package com.paws4home.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "dar_adopcion")
public class DarAdopcion implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_formulario")
    private Long idFormulario;
    private String correo;
    private String fechaFormulario;
    private int cedula;
    private int numero;
    private String nombreMascota;
    private int edadMascota;
    private String motivo;
    private String residencia;
    private boolean recoger;
    private boolean esterilizado;
    private String enfermedad;
    private String informacion;
    private String rutaImagen;

    public DarAdopcion() {
    }

    public DarAdopcion(String correo, String fechaFormulario, int cedula, int numero, String nombreMascota, int edadMascota, String motivo, String residencia, boolean recoger, boolean esterilizado, String enfermedad, String informacion, String rutaImagen) {
        this.correo = correo;
        this.fechaFormulario = fechaFormulario;
        this.cedula = cedula;
        this.numero = numero;
        this.nombreMascota = nombreMascota;
        this.edadMascota = edadMascota;
        this.motivo = motivo;
        this.residencia = residencia;
        this.recoger = recoger;
        this.esterilizado = esterilizado;
        this.enfermedad = enfermedad;
        this.informacion = informacion;
        this.rutaImagen = rutaImagen;
    }
    
    
    
}
