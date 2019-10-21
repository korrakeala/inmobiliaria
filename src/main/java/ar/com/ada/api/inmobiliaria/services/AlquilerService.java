package ar.com.ada.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Alquiler;
import ar.com.ada.api.inmobiliaria.entities.Venta;
import ar.com.ada.api.inmobiliaria.repo.AlquilerRepository;
import ar.com.ada.api.inmobiliaria.repo.VentaRepository;

/**
 * AlquilerService
 */
@Service
public class AlquilerService {

     @Autowired
    AlquilerRepository repo;
    @Autowired
    AvisoService as;
    

     public void grabar(Alquiler a) {
        this.repo.save(a);
    }
}

    