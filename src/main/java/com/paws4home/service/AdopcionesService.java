
package com.paws4home.service;

import com.paws4home.domain.Adopciones;
import java.util.List;


public interface AdopcionesService {
    
    public List<Adopciones> getAdopciones();
    
    public Adopciones getAdopcion(Adopciones adopcion);
    
    public void save(Adopciones adopcion);
    
    public void delete(Adopciones adopcion);
    
}
