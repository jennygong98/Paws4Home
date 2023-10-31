package com.paws4home.service;

import com.paws4home.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    // Se obtiene un listado de usuarios en un Lista
    public List<Usuario> getUsuario(boolean tipoUsuario);

    
   // Se obtiene un usuario, a partir del id de un usuario
    public Usuario getUsuario(Usuario usuario);
    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Usuario usuario);
    
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuario usuario);
}
