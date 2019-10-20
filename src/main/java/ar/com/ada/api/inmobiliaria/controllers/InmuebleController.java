package ar.com.ada.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.models.request.InmuebleRequest;
import ar.com.ada.api.inmobiliaria.models.response.InmuebleResponse;
import ar.com.ada.api.inmobiliaria.services.InmuebleService;

/**
 * InmuebleController
 */
@RestController
public class InmuebleController {
    @Autowired
    InmuebleService inmuebleService;

    @PostMapping("/inmuebles")
    public InmuebleResponse postRegisterinmueble(@RequestBody InmuebleRequest req) {

        inmuebleService.CrearInmueble(req.locadorId, req.tipoInmueble, req.cantAmb, req.direccion, req.superficie,
                req.cantDormitorio, req.aptoProf, req.disposicion, req.cantBanios, req.antiguedadAnios);

        InmuebleResponse r = new InmuebleResponse();
        r.isOk = true;
        r.message = "inmueble creado con exito";

        return r;

    }

}