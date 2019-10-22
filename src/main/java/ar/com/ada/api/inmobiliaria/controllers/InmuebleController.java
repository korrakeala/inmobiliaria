package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.Reserva;
import ar.com.ada.api.inmobiliaria.models.request.InmuebleRequest;
import ar.com.ada.api.inmobiliaria.models.request.ReservarInmuebleRequest;
import ar.com.ada.api.inmobiliaria.models.response.InmuebleResponse;
import ar.com.ada.api.inmobiliaria.models.response.ReservarInmuebleResponse;
import ar.com.ada.api.inmobiliaria.services.InmuebleService;
import ar.com.ada.api.inmobiliaria.services.ReservaService;

/**
 * InmuebleController
 */
@RestController
public class InmuebleController {
    @Autowired
    InmuebleService is;
    @Autowired
    ReservaService rs;

    @PostMapping("/inmuebles") /** funciona! */
    public InmuebleResponse postRegisterInmueble(@RequestBody InmuebleRequest req) {

        Inmueble i = is.CrearInmueble(req.locadorId, req.tipoInmueble, req.cantAmb, req.direccion, req.superficie,
                req.cantDormitorio, req.aptoProf, req.disposicion, req.cantBanios, req.antiguedadAnios);

        InmuebleResponse r = new InmuebleResponse();
        r.isOk = true;
        r.message = "inmueble creado con exito";
        r.inmuebleId = i.getInmuebleId();

        return r;

    }

    @GetMapping("/inmuebles") /** funciona! */
    public List<Inmueble> getInmuebles() {
        List<Inmueble> li = is.getInmuebles();

        return li;
    }

    @GetMapping("/inmuebles/{id}") /** funciona! */
    public Inmueble getInmuebleById(@PathVariable int id) {
        Inmueble in = is.buscarPorId(id);

        return in;
    }

    @GetMapping("/inmuebles/reservas") /** funciona! */
    public List<Reserva> getReservas() {
        List<Reserva> r = rs.listarInmueblesReservados();

        return r;
    }

    @GetMapping("/inmuebles/reservas/{id}")
    public Reserva getReservaById(@PathVariable int id) {
        Reserva r = rs.buscarPorId(id);

        return r;
    }

    @PutMapping("/inmuebles/reservas/{id}")//* falta aplicar IOperable, pero no sé como aplicarlo, así que no funciona
    public ReservarInmuebleResponse updateInmueble(@PathVariable int id, @RequestBody ReservarInmuebleRequest req) {
        ReservarInmuebleResponse r = new ReservarInmuebleResponse();

        Inmueble i = is.updateInmueble( req.inmuebleId, req.reservado);

        r.isOk = true;
        r.message = "Inmueble" + req.inmuebleId + "¡actualizado con éxito!";
        r.reservaId = id;
        return r;
    }

}