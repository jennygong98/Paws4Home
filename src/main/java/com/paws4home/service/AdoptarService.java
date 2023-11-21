
package com.paws4home.service;

import com.paws4home.domain.Adoptar;
import java.util.List;


public interface AdoptarService {
    
    public List<Adoptar> getFormularios();
    
    public Adoptar getFormulario(Adoptar formularioAdoptar);
    
    public void save (Adoptar formularioAdoptar);
}
