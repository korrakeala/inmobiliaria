package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.inmobiliaria.entities.*;
import ar.com.ada.api.inmobiliaria.models.request.*;
import ar.com.ada.api.inmobiliaria.models.response.*;
import ar.com.ada.api.inmobiliaria.services.*;

/**
 * InmuebleController
 */
@RestController
public class InmuebleController {
    @Autowired
    InmuebleService is;
    @Autowired
    ReservaService rs;

    @PostMapping("/inmuebles") // funciona!
    public InmuebleResponse postRegisterInmueble(@RequestBody InmuebleRequest req) {

        Inmueble i = is.crearInmueble(req.locadorId, req.tipoInmueble, req.cantAmb, req.direccion, req.superficie,
                req.cantDormitorio, req.aptoProf, req.disposicion, req.cantBanios, req.antiguedadAnios);

        InmuebleResponse r = new InmuebleResponse();
        r.isOk = true;
        r.message = "inmueble creado con exito";
        r.inmuebleId = i.getInmuebleId();

        return r;

    }

    @GetMapping("/inmuebles") // No funciona xq hay un problema con el Inmueble Id 1
    public List<Inmueble> getInmuebles() {
        List<Inmueble> li = is.getInmuebles();

        return li;
    }

    @GetMapping("/inmuebles/{id}") // funciona! No funciona con el Inmueble Id 1
    public Inmueble getInmuebleById(@PathVariable int id) {
        Inmueble in = is.buscarPorId(id);

        return in;
    }

    @GetMapping("/inmuebles/reservas") // no funciona :(
    public List<Reserva> getReservas() {
        List<Reserva> r = rs.listarReservas();

        return r;
    }
    /** More than one row with the given identifier was found: 1, for class: 
     * ar.com.ada.api.inmobiliaria.entities.Reserva; nested exception is 
     * org.hibernate.HibernateException: More than one row with the given 
     * identifier was found: 1, for class: ar.com.ada.api.inmobiliaria.entities.Reserva */

    @GetMapping("/inmuebles/reservas/{id}")
    public Reserva getReservaById(@PathVariable int id) {
        Reserva r = rs.buscarPorId(id);

        return r;
    }

    @PostMapping("/inmuebles/{id}/reservas") // Funciona!
    public ReservarInmuebleResponse reservarInmueble(@PathVariable int id, @RequestBody ReservaInmuebleRequest req){
        ReservarInmuebleResponse r = new ReservarInmuebleResponse();

        Inmueble i = is.reservarInmueble(id, req.locatarioId);

        r.isOk = true;
        r.message = "Reserva id " + i.getReserva().getReservaId() + " de inmueble id " + i.getInmuebleId() + " creada con éxito!";
        r.reservaId = i.getReserva().getReservaId();
        return r;
    }

    @PutMapping("/inmuebles/{id}/reservas") // Funciona!
    public ReservarInmuebleResponse updateReservaInmueble(@PathVariable int id) {
        ReservarInmuebleResponse r = new ReservarInmuebleResponse();

        Inmueble i = is.modificarReserva(id);

        r.isOk = true;
        r.message = "Reserva " + i.getReserva().getId() + " modificada con éxito!";
        r.reservaId = i.getReserva().getReservaId();
        return r;
    }

}