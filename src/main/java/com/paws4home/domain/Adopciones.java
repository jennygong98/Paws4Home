
package com.paws4home.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Data
@Entity
@Table (name = "mascotas")
public class Adopciones implements Serializable{
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_mascota")
    private Long idMascota;
    private String nombre;
    private int edad;
    private String rutaImagen;

    public Adopciones() {
    }

    public Adopciones(String nombre, int edad, String rutaImagen) {
        this.nombre = nombre;
        this.edad = edad;
        this.rutaImagen = rutaImagen;
    }

   
    

}
