package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Alquiler;
import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Venta;
import ar.com.ada.api.inmobiliaria.models.request.AvisoAlquilerRequest;
import ar.com.ada.api.inmobiliaria.models.request.AvisoVentaRequest;
import ar.com.ada.api.inmobiliaria.models.response.AvisoAlquilerResponse;
import ar.com.ada.api.inmobiliaria.models.response.AvisoVentaResponse;

import ar.com.ada.api.inmobiliaria.services.AlquilerService;
import ar.com.ada.api.inmobiliaria.services.AvisoService;
import ar.com.ada.api.inmobiliaria.services.InmuebleService;

import ar.com.ada.api.inmobiliaria.services.VentaService;


/**
 * AvisoController
 */
@RestController
public class AvisoController {

    @Autowired
    AvisoService as;
    @Autowired
    AlquilerService als;
    @Autowired
    VentaService vs;
    @Autowired
    InmuebleService is;
    
    @PostMapping("/avisos/alquileres") // funciona! exclusivo de usuario inmobiliaria
    public AvisoAlquilerResponse postAvisoAlquiler(@RequestBody AvisoAlquilerRequest req){
        AvisoAlquilerResponse r = new AvisoAlquilerResponse();

        Aviso a = as.crearAvisoAlquiler(req.inmuebleId, req.moneda, req.plazoMeses, req.tipoAlquiler, req.valor);

        r.isOk = true;
        r.message = "Aviso de Alquiler creado con éxito.";
        r.avisoid = a.getAvisoId();
        return r;
    }

    @PostMapping("/avisos/ventas") //funciona! exclusivo de usuario inmobiliaria
    public AvisoVentaResponse postAvisoVenta(@RequestBody AvisoVentaRequest req){
        AvisoVentaResponse r = new AvisoVentaResponse();

        Aviso a = as.crearAvisoVenta(req.inmuebleId, req.moneda, req.valor);

        r.isOk = true;
        r.message = "Aviso de Venta creado con éxito.";
        r.avisoid = a.getAvisoId();
        return r;
    }

    @GetMapping("/avisos") /** funciona! */
    public List<Aviso> getAvisos() {
        List<Aviso> av = as.listarAvisos();

        return av;
    }

    @GetMapping("/avisos/{id}")
    public Aviso getAvisoById(@PathVariable int id) {
        Aviso av = as.buscarPorId(id);

        return av;
    }

    @PutMapping("/avisos/alquileres/{id}") // funciona
    public AvisoAlquilerResponse actualizarAvisoAlquiler(@PathVariable int id, @RequestBody AvisoAlquilerRequest req){
        AvisoAlquilerResponse r = new AvisoAlquilerResponse();
        
        Aviso a = as.buscarPorId(id);
        a.setInmueble(is.buscarPorId(req.inmuebleId));
        Alquiler al = a.getAlquiler();   
        al.setMoneda(req.moneda);
        al.setPlazoMeses(req.plazoMeses);
        al.setTipoAlquiler(req.tipoAlquiler);
        al.setValor(req.valor);
        als.grabar(al);
        a.setOperacionYTipo(al);
        as.grabar(a);
        
        r.isOk = true;
        r.message = "Aviso actualizado con éxito.";
        r.avisoid = a.getAvisoId();
        return r;
    }

    @PutMapping("/avisos/ventas/{id}") // funciona
    public AvisoVentaResponse actualizarAvisoVenta(@PathVariable int id, @RequestBody AvisoVentaRequest req){
        AvisoVentaResponse r = new AvisoVentaResponse();
        
        Aviso a = as.buscarPorId(id);
        a.setInmueble(is.buscarPorId(req.inmuebleId));
        Venta v = a.getVenta();   
        v.setMoneda(req.moneda);
        v.setValor(req.valor);
        vs.grabar(v);
        as.grabar(a);
        
        r.isOk = true;
        r.message = "Aviso actualizado con éxito.";
        r.avisoid = a.getAvisoId();
        return r;
    }



    /*@GetMapping("/avisos/alquileres") /** funciona! 
    public List<Alquiler> getAlquileres() {
        List<Alquiler> al = als.listarAlquileres();

        return al;
    }

    @GetMapping("/avisos/alquileres/{id}")

    public Alquiler getAlquilerById(@PathVariable int id) {
        Alquiler al = als.buscarPorId(id);

        return al;
    }

    @GetMapping("/avisos/ventas") /** funciona!

    public List<Venta> getVentas() {
        List<Venta> v = vs.listarVentas();

        return v;
    }

    @GetMapping("/avisos/ventas/{id}")

    public Venta getVentaById(@PathVariable int id) {
        Venta v = vs.buscarPorId(id);

        return v;
    }*/

    /**
     * usamos las querys para filtrar por tipo de operacion
     */


}