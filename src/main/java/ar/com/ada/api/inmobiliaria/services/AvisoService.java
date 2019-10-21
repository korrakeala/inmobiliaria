package ar.com.ada.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.repo.AvisoRepository;

/**
 * AvisoService
 */
@Service
public class AvisoService {

    @Autowired
    AvisoRepository repo;

       public void grabar(Aviso aviso) {
        this.repo.save(aviso);
    }

    public void crearAviso() {
    }
}
    

    
        
       

