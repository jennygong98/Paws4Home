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
      private String comentario;
      private boolean activo;

      public Foro() {
      }

      public Foro(long idForo, String comentario, boolean activo) {
	   this.idForo = idForo;
	   this.comentario = comentario;
	   this.activo = activo;
      }

}
