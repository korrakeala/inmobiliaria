package ar.com.ada.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.models.request.UserRequest;
import ar.com.ada.api.inmobiliaria.models.response.UserResponse;
import ar.com.ada.api.inmobiliaria.services.UsuarioService;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService userService;
    
    @PostMapping("/usuarios")
    public UserResponse postRegisterUser(@RequestBody UserRequest req){
        userService.CrearUser(req.userName, req.password, req.email);
    
        UserResponse r = new UserResponse();
        r.isOk = true;
        r.message = "Usuario creado con exito";

        return r;

    }
    
}