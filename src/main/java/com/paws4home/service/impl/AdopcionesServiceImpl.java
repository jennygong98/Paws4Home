
package com.paws4home.service.impl;

import com.paws4home.dao.AdopcionesDao;
import com.paws4home.domain.Adopciones;
import com.paws4home.service.AdopcionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdopcionesServiceImpl implements AdopcionesService{

    @Autowired
    private AdopcionesDao adopcionesDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Adopciones> getAdopciones() {
        List<Adopciones> adopciones = adopcionesDao.findAll();
        
        return adopciones;
    }

    @Override
    public Adopciones getAdopcion(Adopciones adopcion) {
        return adopcionesDao.findById(adopcion.getIdMascota()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Adopciones adopcion) {
        //metodo deberia llevar la info del form a una tabla
        //o deberia permitir ingresar nuevas mascotas
    }

    @Override
    @Transactional
    public void delete(Adopciones adopcion) {
        adopcionesDao.delete(adopcion);
    }
    

    
    
}
