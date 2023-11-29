
package com.paws4home.service.impl;


import com.paws4home.domain.Adoptar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.paws4home.dao.AdoptarDao;
import com.paws4home.service.AdoptarService;


@Service
public class AdoptarServiceImpl implements AdoptarService{

    @Autowired
    private AdoptarDao formularioAdoptarDao;
    
    @Override
    @Transactional
    public List<Adoptar> getFormularios(){
        List<Adoptar> formularios = formularioAdoptarDao.findAll();
        
        return formularios;
    }

    @Override
    public Adoptar getFormulario(Adoptar formularioAdoptar) {
        return formularioAdoptarDao.findById(formularioAdoptar.getIdFormulario()).orElse(null);
    }

    @Override
    public void save(Adoptar formularioAdoptar) {
        formularioAdoptarDao.save(formularioAdoptar);
    }
    
    @Override
    public List<Adoptar> findByMascotaId(Long id) {
        List<Adoptar>forms= formularioAdoptarDao.findByMascotaId(id);
        return forms;
    }

    @Override
    public void delete(Adoptar id) {
        formularioAdoptarDao.delete(id);
    }
    
}
