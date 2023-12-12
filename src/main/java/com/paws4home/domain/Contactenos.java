package com.paws4home.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "contactenos")
public class Contactenos implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contactenos")
    private Long idContactenos;
    private String nombre;
    private int telefono;
    private String correo;
    private String comentario;

    public Contactenos() {
    }

    public Contactenos(String nombre, int telefono, String correo, String comentario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.comentario = comentario;
    }
    
    
}
