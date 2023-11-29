package com.paws4home.service.impl;

import com.paws4home.dao.UsuarioDao;
import com.paws4home.domain.Rol;
import com.paws4home.domain.Usuario;
import com.paws4home.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Buscar el usuario por el username en la BD
        Usuario usuario = usuarioDao.findByUsername(username);
        
        //si no existe el usuario, lanza una excepción
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        //Transformar roles a GrantedAuthority
        var roles= new ArrayList<GrantedAuthority>();
        for(Rol item : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(item.getNombre()));
        } 
        
        //retorna el user (Clase UserDetails)
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
    
}