package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Locatario;
import ar.com.ada.api.inmobiliaria.models.request.LocatarioRequest;
import ar.com.ada.api.inmobiliaria.models.response.LocatarioResponse;
import ar.com.ada.api.inmobiliaria.services.LocatarioService;

/**
 * LocatarioController
 */
@RestController
public class LocatarioController {

    @Autowired
    LocatarioService ls;

    /*
    @PostMapping("/locatarios") //funciona!
    public LocatarioResponse postCrearLocatarioYUsuario(@RequestBody LocatarioRequest req){
        LocatarioResponse r = new LocatarioResponse();

        Locatario l = ls.crearLocatario(req.nombre, req.dni, req.edad, req.email, req.password, req.estadoUsuario);

        r.isOk = true;
        r.message = "Locatario generado";
        r.locatarioId = l.getLocatarioId();
        return r; 
    }*/

    @GetMapping("/locatarios") /**funciona */
    public List<Locatario> getLocatarios() {

        List<Locatario> locatarios = ls.listarLocatariosYUsuarios();

        return locatarios;

    }
    
    @GetMapping("/locatarios/{id}") /**funciona! */
    public Locatario getLocatarioById(@PathVariable int id)
    {
        Locatario l = ls.buscarPorId(id);
        
        return l;
    }

    @DeleteMapping("/locatarios/{id}")
    public LocatarioResponse bajaLocatario(@PathVariable int id){
        LocatarioResponse r = new LocatarioResponse();

        Locatario l = ls.bajaLocatario(id);

        r.isOk = true;
        r.message = "Locatario " + l.getNombre() + " dado de baja.";
        r.locatarioId = l.getId();

        return r;
    }

}