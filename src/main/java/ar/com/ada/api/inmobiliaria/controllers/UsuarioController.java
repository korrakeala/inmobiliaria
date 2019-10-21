package ar.com.ada.api.inmobiliaria.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Usuario;
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
        
        Usuario u = us.crearUsuario(req.userName, req.password, req.email, req.tipoUsuario);
    
        UsuarioResponse r = new UsuarioResponse();
        r.isOk = true;
        r.message = "Usuario creado con exito";
        r.usuarioId = u.getTipoUsuario();
        
        return r;

    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {

        List<Usuario> usuarios = us.listarUsuarios();

        return usuarios;

    }

}