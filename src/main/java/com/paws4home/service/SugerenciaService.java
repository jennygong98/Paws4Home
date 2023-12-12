
package com.paws4home.service;

import com.paws4home.domain.Sugerencia;
import java.util.List;


public interface SugerenciaService {
    // Se obtiene un listado de sugerencias en un List
    public List<Sugerencia> getSugerencias();
    
   // Se obtiene una sugerencia, a partir del id de una sugerencia
    public Sugerencia getSugerencia(Sugerencia sugerencia);
    
    // Se inserta una nueva Sugerencia si el id de la Sugerencia esta vacío
    // Se actualiza una Sugerencia si el id de la Sugerencia NO esta vacío
    public void save(Sugerencia sugerencia);
    
    public void delete (Sugerencia sugerencia);
    
}
