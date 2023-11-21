
package com.paws4home.service;

import com.paws4home.domain.Mascota;
import java.util.List;


public interface MascotaService {
    
    public List<Mascota> getMascotas(boolean activos);
    
    public Mascota getMascota(Mascota mascota);
    
    public void save(Mascota mascota);
    
    public void delete(Mascota mascota);
    
}
