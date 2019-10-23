package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.models.request.InmobiliariaRequest;
import ar.com.ada.api.inmobiliaria.models.request.LocadorRequest;
import ar.com.ada.api.inmobiliaria.models.response.InmobiliariaResponse;
import ar.com.ada.api.inmobiliaria.models.response.LocadorResponse;
import ar.com.ada.api.inmobiliaria.services.InmobiliariaService;
import ar.com.ada.api.inmobiliaria.services.LocadorService;

@RestController
public class InmobiliariaController {

    @Autowired
    InmobiliariaService is;

    @Autowired
    LocadorService ls;

    @PostMapping("/inmobiliarias") // funciona! habría que poner restricción para que se pueda crear sólo una?
    public InmobiliariaResponse postCrearInmobiliariaYUsuario(@RequestBody InmobiliariaRequest req) {
        InmobiliariaResponse r = new InmobiliariaResponse();

        int inmobiliariaId = is.crearInmobiliaria(req.cuit, req.nombre, req.email, req.password, req.estadoUsuario,
                req.fechaAltaUsuario);
        r.isOk = true;
        r.message = "Inmobiliaria generada";
        r.inmobiliariaId = inmobiliariaId;
        return r;
    }

    @PostMapping("/locadores") // funciona! método específico para tipo de usuario Inmobiliaria
    public LocadorResponse postRegisterLocador(@RequestBody LocadorRequest req) {
        LocadorResponse r = new LocadorResponse();

        Locador l = is.crearLocador(req.nombre, req.dni, req.edad, req.email);

        r.isOk = true;
        r.message = "Locador generado con éxito.";
        r.locadorId = l.getLocadorId();
        return r;

    }

    @GetMapping("/locadores") /** funciona! método específico para tipo de usuario Inmobiliaria*/

     public List<Locador> getLocadores()/**@RequestParam(value = "nombre", required = false) String nombre*/ {

        List<Locador> locadores = ls.listarLocadores();

        /**if (nombre == null) {
            locadores = ls.buscarLocadoresOrdenadoPorNombre();
        } else {
            locadores = ls.buscarTodosPorNombre(nombre);
        }*/


        return locadores;

    }

    @GetMapping("/locadores/{id}") /** funciona! método específico para tipo de usuario Inmobiliaria*/
    public Locador getLocador(@PathVariable int id) {

        Locador l = ls.buscarPorId(id);

        return l;

    }

}