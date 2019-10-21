package ar.com.ada.api.inmobiliaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.repo.LocadorRepository;


@Service
public class LocadorService {
    @Autowired
    LocadorRepository locadorRepo;
    
    public Locador buscarPorId(int id){
        Optional<Locador> l = locadorRepo.findById(id);
        
        if (l.isPresent())
            return l.get();
        return null;

    }

     public void grabar(Locador locador) {
        this.locadorRepo.save(locador);
    }



    
}
