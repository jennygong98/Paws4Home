
package com.paws4home.service.impl;

import com.paws4home.dao.DarAdopcionDao;
import com.paws4home.domain.DarAdopcion;
import com.paws4home.service.DarAdopcionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DarAdopcionServiceImpl implements DarAdopcionService{

    @Autowired
    private DarAdopcionDao darAdopcionDao;
    
    @Override
    @Transactional
    public List<DarAdopcion> getSolicitudes() {
        List<DarAdopcion> solicitudes = darAdopcionDao.findAll();
        
        return solicitudes;
    }

    @Override
    public void save(DarAdopcion solicitud) {
        darAdopcionDao.save(solicitud);
    }
    
}
