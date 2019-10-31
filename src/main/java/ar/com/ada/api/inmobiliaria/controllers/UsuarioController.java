package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.services.UsuarioService;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService us;

    @GetMapping("/usuarios") // exclusivo de tipo de usuario Inmobiliaria
    public List<Usuario> getUsuarios() {

        List<Usuario> usuarios = us.listarUsuarios();

        return usuarios;

    }

}