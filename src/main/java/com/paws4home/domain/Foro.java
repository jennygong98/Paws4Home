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
@Table(name = "foro")
public class Foro implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foro")
    private long idForo;
    private String titulo;
    private String comentario;
    private String usuario;

    public Foro() {
    }

    public Foro(long idForo, String titulo, String comentario, String usuario) {
        this.idForo = idForo;
        this.titulo = titulo;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    

  

}
