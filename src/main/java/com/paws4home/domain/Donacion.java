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
@Table(name = "donacion")
public class Donacion implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donacion")
    
    private long idDonacion;
    private String descripcion;
    private double monto;
   
    
    public Donacion (){}

    public Donacion(long idDonacion, String descripcion, double monto) {
        this.idDonacion = idDonacion;
        this.descripcion = descripcion;
        this.monto = monto;
        
    }
    
}
