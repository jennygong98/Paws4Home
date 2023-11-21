package com.paws4home.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "adoptar")
public class Adoptar implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_formulario")
    private Long idFormulario;
    private String correo;
    private String nombre;
    private String primApellido;
    private String segApellido;
    private int edad;
    private int cedula;
    private String residencia;
    private String empresa;
    private String cargo;
    private int celular;
    private int referencia;
    private String habitantes;
    private String alergias;
    private String tipoInmueble;
    private String motivo;
    private boolean disponible;
    private String duda;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    Mascota mascota;
    
    public Adoptar() {
    }

    public Adoptar(String correo, String nombre, String primApellido, String segApellido, int edad, int cedula, String residencia, String empresa, String cargo, int celular, int referencia, String habitantes, String alergias, String tipoInmueble, String motivo, boolean disponible, String duda, Mascota mascota) {
        this.correo = correo;
        this.nombre = nombre;
        this.primApellido = primApellido;
        this.segApellido = segApellido;
        this.edad = edad;
        this.cedula = cedula;
        this.residencia = residencia;
        this.empresa = empresa;
        this.cargo = cargo;
        this.celular = celular;
        this.referencia = referencia;
        this.habitantes = habitantes;
        this.alergias = alergias;
        this.tipoInmueble = tipoInmueble;
        this.motivo = motivo;
        this.disponible = disponible;
        this.duda = duda;
        this.mascota = mascota;
    }

    

}
