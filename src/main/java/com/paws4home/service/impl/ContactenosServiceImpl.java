package com.paws4home.service.impl;

import com.paws4home.dao.ContactenosDao;
import com.paws4home.domain.Contactenos;
import com.paws4home.service.ContactenosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactenosServiceImpl implements ContactenosService {

    @Autowired
    private ContactenosDao contactenosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contactenos> getContactenos() {
        List<Contactenos> contactenos = contactenosDao.findAll();
        return contactenos;
    }

    @Override
    public Contactenos getContactenos(Contactenos contactenos) {
        return contactenosDao.findById(contactenos.getIdContactenos()).orElse(null);
    }

    @Override
    public void save(Contactenos contactenos) {
        contactenosDao.save(contactenos);
    }

    @Override
    public void delete(Contactenos contactenos) {
        contactenosDao.delete(contactenos);
    }

}
