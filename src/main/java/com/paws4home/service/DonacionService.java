/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.paws4home.service;

import com.paws4home.domain.Donacion;
import java.util.List;

/**
 *
 * @author mija2
 */
public interface DonacionService {
    public List<Donacion> getDonaciones(boolean activos);
    
    public Donacion getDonacion(Donacion donaciones);
    
    public void save (Donacion donaciones);
    
    public void delete(Donacion donaciones);
}
