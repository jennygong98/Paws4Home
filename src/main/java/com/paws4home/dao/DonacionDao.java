/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.paws4home.dao;

import com.paws4home.domain.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mija2
 */
public interface DonacionDao extends JpaRepository<Donacion, Long>{
    
}
