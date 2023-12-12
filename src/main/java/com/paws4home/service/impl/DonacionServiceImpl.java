
package com.paws4home.service.impl;

import com.paws4home.dao.DonacionDao;
import com.paws4home.domain.Donacion;
import com.paws4home.service.DonacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DonacionServiceImpl implements DonacionService{
    
    @Autowired
    private DonacionDao donacionDao;
    
    @Override
    @Transactional(readOnly = true) 
    public List<Donacion> getDonaciones(boolean activos){
        List<Donacion> donaciones = donacionDao.findAll();
        return donaciones;
    }
    public Donacion getDonacion(Donacion donacion){
        return donacionDao.findById(donacion.getIdDonacion()).orElse(null);
    }
    @Override
    @Transactional
    public void save(Donacion donaciones){
        donacionDao.save(donaciones);
    }
    
    public void delete(Donacion donacion){
        donacionDao.delete(donacion);
    }
}
