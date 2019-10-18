package ar.com.ada.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import ar.com.ada.api.inmobiliaria.entities.Inmueble;
=======
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.Inmueble;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer>{
>>>>>>> 03cd3f92fa58ff6cc0ebb3d381cfbab593cd5c10

/**
 * InmuebleRepository
 */
public interface InmuebleRepository extends JpaRepository<Inmueble , Integer>{

    
}