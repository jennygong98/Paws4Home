
package com.paws4home.service.impl;

import com.paws4home.domain.Mascota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.paws4home.dao.MascotaDao;
import com.paws4home.service.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    private MascotaDao mascotaDao;
    
   @Override
    @Transactional (readOnly = true)
    public List<Mascota> getMascotas() {
        List<Mascota> mascotas = mascotaDao.findAll();
        
        return mascotas;
    }

    @Override
    public Mascota getMascota(Mascota mascota) {
        return mascotaDao.findById(mascota.getIdMascota()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Mascota mascota) {
        mascotaDao.save(mascota);
    }

    @Override
    @Transactional
    public void delete(Mascota mascota) {
        mascotaDao.delete(mascota);
    }
     
    
}
