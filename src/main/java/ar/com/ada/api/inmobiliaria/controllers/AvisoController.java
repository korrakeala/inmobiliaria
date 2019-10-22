package ar.com.ada.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.Alquiler;
import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Venta;
import ar.com.ada.api.inmobiliaria.services.AlquilerService;
import ar.com.ada.api.inmobiliaria.services.AvisoService;
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


    @GetMapping("/avisos")
     public List<Aviso> getAvisos() {
        List<Aviso> av = as.listarAvisos();

        return av;
     }

    @GetMapping("/avisos/{id}")
    public Aviso getAvisoById(@PathVariable int id)
    {
        Aviso av = as.buscarPorId(id);
        
        return av;
    }

    @GetMapping("/avisos/alquileres")
     public List<Alquiler> getAlquileres() {
        List<Alquiler> al = als.listarAlquileres();

        return al;
     }


    @GetMapping("/avisos/alquileres/{id}")

    public Alquiler getAlquilerById(@PathVariable int id)
    {
        Alquiler al = als.buscarPorId(id);
        
        return al;
    }

    @GetMapping("/avisos/ventas")

      public List<Venta> getVentas() {
        List<Venta> v = vs.listarVentas();

        return v;
     }

     @GetMapping("/avisos/ventas/{id}")

    public Venta getVentaById(@PathVariable int id)
    {
        Venta v = vs.buscarPorId(id);
        
        return v;
    }


/**usamos las querys para filtrar por tipo deoperacion o generamos get alquiler y get venta para listarlos? */

    
}