package com.paws4home.service;

import com.paws4home.domain.Usuario;
import org.springframework.security.core.userdetails.*;



public interface UsuarioDetailsService {
   
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
        
    public Usuario getUsuarioPorUsername(String username);
    
}
