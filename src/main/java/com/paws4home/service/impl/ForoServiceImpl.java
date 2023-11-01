package com.paws4home.service.impl;

import com.paws4home.dao.ForoDao;
import com.paws4home.domain.Foro;
import com.paws4home.service.ForoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForoServiceImpl implements ForoService {

     @Autowired
     private ForoDao foroDao;

     @Override
     @Transactional(readOnly = true)
     public List<Foro> getForos(boolean activos) {
          List<Foro> foros = foroDao.findAll();
          
          return foros;
     }

     @Override
     public Foro getForo(Foro foro) {
          return foroDao.findById(foro.getIdForo()).orElse(null);
     }

     @Override
     @Transactional
     public void save(Foro foro) {
          foroDao.save(foro);
     }

     @Override
     @Transactional
     public void delete(Foro foro) {
          foroDao.delete(foro);
     }
}
