package ar.com.ada.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.entities.Venta;
import ar.com.ada.api.inmobiliaria.repo.VentaRepository;

/**
 * VentaService
 */
@Service
public class VentaService {

    @Autowired
    VentaRepository repo;
    @Autowired
    AvisoService as;
    

     public void grabar(Venta v) {
        this.repo.save(v);
    }
}
   