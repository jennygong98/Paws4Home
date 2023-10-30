package com.paws4home.service;

import com.paws4home.domain.Foro;
import java.util.List;

public interface ForoService {

      public List<Foro> getForos(boolean activos);

      public Foro getForo(Foro foro);

      public void save(Foro foro);

      public void delete(Foro foro);
}
