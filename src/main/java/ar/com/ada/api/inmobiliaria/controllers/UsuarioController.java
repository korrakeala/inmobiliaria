package ar.com.ada.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.models.request.UsuarioRequest;
import ar.com.ada.api.inmobiliaria.models.response.UsuarioResponse;
import ar.com.ada.api.inmobiliaria.services.UsuarioService;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService us;
    
    @PostMapping("/usuarios")
    public UsuarioResponse postRegUsuario(@RequestBody UsuarioRequest req){
        us.crearUsuario(req.userName, req.password, req.email);
    
        UsuarioResponse r = new UsuarioResponse();
        r.isOk = true;
        r.message = "Usuario creado con exito";

        return r;

    }
    
}