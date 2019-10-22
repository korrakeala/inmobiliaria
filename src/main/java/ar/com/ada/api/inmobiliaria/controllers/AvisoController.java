package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.services.AlquilerService;
import ar.com.ada.api.inmobiliaria.services.AvisoService;
import ar.com.ada.api.inmobiliaria.services.VentaService;

/**
 * AvisoController
 */
@RestController
public class AvisoController {

    @Autowired
    AvisoService as;
    @Autowired
    AlquilerService als;
    @Autowired 
    VentaService vs;


    @GetMapping("/avisos")
     public List<Aviso> getAvisos() {
        List<Aviso> av = as.listarAvisos();

        return av;
     }

    @GetMapping("/avisos/{id}")
    public Aviso getAvisoById(@PathVariable int id)
    {
        Aviso av = as.buscarPorId(id);
        
        return av;
    }

    

    
}