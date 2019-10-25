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

    @PostMapping("/inmuebles") /** funciona! método específico para tipo de usuario Inmobiliaria*/
    public InmuebleResponse postRegisterInmueble(@RequestBody InmuebleRequest req) {

        Inmueble i = is.crearInmueble(req.locadorId, req.tipoInmueble, req.cantAmb, req.direccion, req.superficie,
                req.cantDormitorio, req.aptoProf, req.disposicion, req.cantBanios, req.antiguedadAnios);

        InmuebleResponse r = new InmuebleResponse();
        r.isOk = true;
        r.message = "inmueble creado con exito";
        r.inmuebleId = i.getInmuebleId();

        return r;

    }

    @GetMapping("/inmuebles") /** funciona! método específico para tipo de usuario Inmobiliaria*/
    public List<Inmueble> getInmuebles() {
        List<Inmueble> li = is.getInmuebles();

        return li;
    }

    @GetMapping("/inmuebles/{id}") /** funciona! método específico para tipo de usuario Inmobiliaria*/
    public Inmueble getInmuebleById(@PathVariable int id) {
        Inmueble in = is.buscarPorId(id);

        return in;
    }

    @GetMapping("/inmuebles/reservas") /** funciona! método específico para tipo de usuario Inmobiliaria*/
    public List<Reserva> getReservas() {
        List<Reserva> r = rs.listarReservas();

        return r;
    }

    @GetMapping("/inmuebles/reservas/{id}") //método específico para tipo de usuario Inmobiliaria
    public Reserva getReservaById(@PathVariable int id) {
        Reserva r = rs.buscarPorId(id);

        return r;
    }

    //no encuentra el locatario, no entiendo por qué si en GetLocatarioById funciona
    @PostMapping("/inmuebles/reservas/{id}")
    //probé con @Pathvariable pero me dice "Optional int parameter 'locatid' is present but cannot be 
    // translated into a null value due to being declared as a primitive type. Consider declaring it
    // as object wrapper for the corresponding primitive type."
    public ReservarInmuebleResponse reservarInmueble(@PathVariable int id, @RequestBody ReservaInmuebleRequest req){
        ReservarInmuebleResponse r = new ReservarInmuebleResponse();

        Inmueble i = is.reservarInmueble(id, req.locatarioId);

        r.isOk = true;
        r.message = "Reserva id " + i.getReserva().getReservaId() + " de inmueble id " + i.getInmuebleId() + " creada con éxito!";
        r.reservaId = i.getReserva().getReservaId();
        return r;
    }

    @PutMapping("/inmuebles/reservas/{id}") // No funciona aún, será incorporado para tercera entrega
    public ReservarInmuebleResponse updateInmueble(@PathVariable int id, @RequestBody ReservaInmuebleRequest req) {
        ReservarInmuebleResponse r = new ReservarInmuebleResponse();

        Inmueble i = is.reservarInmueble(id, req.locatarioId);

        r.isOk = true;
        r.message = "Inmueble" + i.getInmuebleId() + "¡actualizado con éxito!";
        r.reservaId = i.getReserva().getReservaId();
        return r;
    }

}