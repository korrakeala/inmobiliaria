package ar.com.ada.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.Locador;

import java.util.*;


/**
 * LocadorRepository
 */
@Repository
public interface LocadorRepository extends JpaRepository<Locador, Integer>{

    
   // @Query("select l from Locador l order by nombre")
    List<Locador> findAllOrderByNombre();

	List<Locador> findAllByNombreContiene(String nombre);
    
}