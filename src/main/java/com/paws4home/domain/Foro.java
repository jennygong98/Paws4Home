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
      @Column(name = "cod_foro")
      private long codForo;
      private String descripcion;
      private int idUsuario;
      private int comentario;
      private boolean activo;

      public Foro() {
      }

      public Foro(long codForo, String descripcion, int idUsuario, int comentario, boolean activo) {
	   this.codForo = codForo;
	   this.descripcion = descripcion;
	   this.idUsuario = idUsuario;
	   this.comentario = comentario;
	   this.activo = activo;
      }

}
