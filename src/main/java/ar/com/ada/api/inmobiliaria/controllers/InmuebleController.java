package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.Persona;
import ar.com.ada.api.inmobiliaria.models.request.InmuebleRequest;
import ar.com.ada.api.inmobiliaria.models.response.InmuebleResponse;
import ar.com.ada.api.inmobiliaria.services.InmuebleService;

/**
 * InmuebleController
 */
@RestController
public class InmuebleController {
    @Autowired
    InmuebleService is;

    @PostMapping("/inmuebles")
    public InmuebleResponse postRegisterInmueble(@RequestBody InmuebleRequest req) {

        Inmueble i = is.CrearInmueble(req.locadorId, req.tipoInmueble, req.cantAmb, req.direccion, req.superficie,
                req.cantDormitorio, req.aptoProf, req.disposicion, req.cantBanios, req.antiguedadAnios);

        InmuebleResponse r = new InmuebleResponse();
        r.isOk = true;
        r.message = "inmueble creado con exito";
        r.inmuebleId = i.getInmuebleId();

        return r;

    }



    @GetMapping("/inmuebles")
     public List<Inmueble> getInmuebles() {
        List<Inmueble> li = is.getInmuebles();

        return li;
     }

    @GetMapping("/inmuebles/{id}")
    public Inmueble getInmuebleById(@PathVariable int id)
    {
        Inmueble in = is.buscarPorId(id);
        
        return in;
    }

}