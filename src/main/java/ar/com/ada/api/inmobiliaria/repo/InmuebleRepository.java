package ar.com.ada.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.inmobiliaria.entities.Inmueble;

/**
 * InmuebleRepository
 */
public interface InmuebleRepository extends JpaRepository<Inmueble , Integer>{

    
}