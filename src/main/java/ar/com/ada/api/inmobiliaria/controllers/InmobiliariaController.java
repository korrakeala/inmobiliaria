package ar.com.ada.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.models.request.InmobiliariaRequest;
import ar.com.ada.api.inmobiliaria.models.response.InmobiliariaResponse;
import ar.com.ada.api.inmobiliaria.services.InmobiliariaService;

/**
 * InmobiliariaController
 */
@RestController
public class InmobiliariaController {

    @Autowired 
    InmobiliariaService is;

    @PostMapping("/inmobiliarias")
    public InmobiliariaResponse postCrearInmobiliaria(@RequestBody InmobiliariaRequest req){
        InmobiliariaResponse r = new InmobiliariaResponse();

        int inmobiliariaId = is.crearInmobiliaria(req.cuil, req.nombre, req.email);

        r.isOk = true;
        r.message = "Inmobiliaria generada";
        r.inmobiliariaId = inmobiliariaId;
        return r; 
    }



    
}