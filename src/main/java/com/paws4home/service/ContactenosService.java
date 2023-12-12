
package com.paws4home.service;
import com.paws4home.domain.Contactenos;
import java.util.List;

public interface ContactenosService {
    
    public List<Contactenos> getContactenos();
    
    public Contactenos getContactenos(Contactenos contactenos);
    
    public void save(Contactenos contactenos);
    
    public void delete (Contactenos contactenos);
}
