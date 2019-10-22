package ar.com.ada.api.inmobiliaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Aviso;
import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.interfaces.IOperable;
import ar.com.ada.api.inmobiliaria.repo.AvisoRepository;

/**
 * AvisoService
 */
@Service
public class AvisoService {

    @Autowired
    AvisoRepository repo;
    @Autowired
    InmuebleService is;
    @Autowired 
    LocadorService ls;

       public void grabar(Aviso aviso) {
        this.repo.save(aviso);
    }

        public Aviso buscarPorId(int id) {
        Optional<Aviso> a = repo.findById(id);

        if (a.isPresent())
            return a.get();
        return null;

    }

    /**public void crearAviso(String tipoAlquiler,String moneda,double valor,String plazoMeses,IOperable tipoOperacion,Inmueble inmueble){

        Aviso av = new Aviso();

        

        av.setTipoOperacion(tipoOperacion);
        av.setInmueble()
        Locador loc = ls.buscarPorId();

        Inmueble i = is.CrearInmueble(locadorId, tipoInmueble, cantAmb, direccion, superficie, cantDormitorio, aptoProf, disposicion, cantBanios, antiguedadAnios)



        loc.agregarInmueble(i);
        
        repo.save(i);
        return i;}*/



    
    public List<Aviso> listarAvisos() {
        return repo.findAll();
    }

}
    

    
        
       

