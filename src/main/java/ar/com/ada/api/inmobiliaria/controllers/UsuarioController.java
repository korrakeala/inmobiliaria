package ar.com.ada.api.inmobiliaria.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.models.request.UserRequest;
import ar.com.ada.api.inmobiliaria.models.response.UserResponse;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {

    @UsuarioService us;
    
    @PostMapping("/usuarios")

    public UserResponse postRegisterUser(@RequestBody UserRequest req)
    UserResponse r = new UserResponse();

    int usuarioCreadoId =


    
}