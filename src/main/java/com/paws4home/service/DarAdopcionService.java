
package com.paws4home.service;

import com.paws4home.domain.DarAdopcion;
import java.util.List;


public interface DarAdopcionService {
    
    public List<DarAdopcion> getSolicitudes();
    
    public void save (DarAdopcion solicitud);
    
}
