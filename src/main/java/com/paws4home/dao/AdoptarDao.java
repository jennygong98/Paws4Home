
package com.paws4home.dao;

import com.paws4home.domain.Adoptar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AdoptarDao extends JpaRepository<Adoptar, Long>{
    
    //jpql
    @Query(value = "SELECT a FROM Adoptar a WHERE a.mascota.id = :mascotaId")
    List<Adoptar> findByMascotaId(@Param("mascotaId") Long mascotaId);
}
