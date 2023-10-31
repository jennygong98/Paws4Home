package com.paws4home.service.impl;

import com.paws4home.dao.UsuarioDao;
import com.paws4home.domain.Usuario;
import com.paws4home.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuario(boolean tipoUsuario) {
        List<Usuario> usuario = usuarioDao.findAll();
        if (tipoUsuario) {
           usuario.removeIf(e -> !e.isTipoUsuario());
        }
        return usuario;
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }


}
