package ar.com.ada.api.inmobiliaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Alquiler;
import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.repo.AlquilerRepository;

/**
 * AlquilerService
 */
@Service
public class AlquilerService {

    @Autowired
    AlquilerRepository repo;
    @Autowired
    AvisoService as;

    public void grabar(Alquiler a) {
        this.repo.save(a);
    }

    public Alquiler buscarPorId(int id) {
        Optional<Alquiler> a = repo.findById(id);

        if (a.isPresent())
            return a.get();
        return null;
    }

        
    public List<Alquiler> listarAlquileres() {
        return repo.findAll();
    }

}
