package com.paws4home.service.impl;

import com.paws4home.dao.SugerenciaDao;
import com.paws4home.domain.Sugerencia;
import com.paws4home.service.SugerenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SugerenciaServiceImpl implements SugerenciaService {

    @Autowired
    private SugerenciaDao sugerenciaDao;

    @Override
    public List<Sugerencia> getSugerencias() {
         List<Sugerencia> sugerencia = sugerenciaDao.findAll();
        
        return sugerencia;
    }


    @Override
    public Sugerencia getSugerencia(Sugerencia sugerencia) {
        return sugerenciaDao.findById(sugerencia.getIdSugerencia()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Sugerencia sugerencia) {
        sugerenciaDao.save(sugerencia);
    }
    
    @Override
    @Transactional
    public void delete (Sugerencia sugerencia) {
        sugerenciaDao.delete(sugerencia);
    }

   
}
