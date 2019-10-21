package ar.com.ada.api.inmobiliaria.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Reserva;
import ar.com.ada.api.inmobiliaria.repo.ReservaRepository;

/**
 * ReservaService
 */
@Service
public class ReservaService {

    @Autowired
    ReservaRepository repo;

        public void grabar(Reserva reserva) {
        this.repo.save(reserva);
    }

    /**public void crearReserva(int avisoId,Date fecha, String inmueble, int id, String locatario) {
        Reserva reserva = new Reserva();
        reserva.setAviso(avisoId);
        reserva.setFecha(fecha);
        reserva.setInmueble(inmueble);
        reserva.setId(id);
        reserva.setLocatario(locatario);

        repo.save(reserva);

    }*/


    public Reserva buscarPorId(int id){
        Optional<Reserva> r = repo.findById(id);
        
        if (r.isPresent())
            return r.get();
        return null;

    }


    public List<Reserva> listarInmueblesReservados(){
        return repo.findAll();
    }

    
}