package ar.com.ada.api.inmobiliaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Inmobiliaria;
import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.repo.InmobiliariaRepository;
import ar.com.ada.api.inmobiliaria.repo.LocadorRepository;

/**
 * InmobiliariaService
 */
@Service
public class InmobiliariaService {

    @Autowired
    InmobiliariaRepository repo;
    @Autowired
    LocadorService ls;
    @Autowired
    UsuarioService us;

    public void grabar(Inmobiliaria inmobiliaria) {
        this.repo.save(inmobiliaria);
    }

    public void crearInmobiliaria(String cuil, int inmobiliariaId, String nombre, String email) {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(u.getEmail());

        u.getUsuarioId();

        Inmobiliaria inmo = new Inmobiliaria();
        inmo.setCuil(cuil);
        inmo.setInmobiliariaId(inmobiliariaId);
        inmo.setNombre(nombre);

        u.setTipoUsuario(inmo);

        repo.save(inmo);

    }

    public Inmobiliaria buscarPorId(int id) {
        Optional<Inmobiliaria> i = repo.findById(id);

        if (i.isPresent())
            return i.get();
        return null;

    }

    public Inmobiliaria updateInmobiliaria(String cuil, String nombre) {
        Inmobiliaria i = new Inmobiliaria();
        i.setCuil(cuil);
        i.setNombre(nombre);
        repo.save(i);
        return i;
    }
    


    public Locador crearLocador(String nombre, int dni, int edad, String email) {
        Locador loc = new Locador();
        loc.setNombre(nombre);
        loc.setDni(dni);
        loc.setEdad(edad);
        loc.setEmail(email);
        ls.grabar(loc);

        return loc;

    }

     

    

    
}