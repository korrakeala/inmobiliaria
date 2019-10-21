package ar.com.ada.api.inmobiliaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.Locador;
import ar.com.ada.api.inmobiliaria.repo.InmuebleRepository;

/**
 * InmuebleService
 */
@Service
public class InmuebleService {
    @Autowired
    InmuebleRepository repo;

    @Autowired
    InmobiliariaService is;

    @Autowired
    LocadorService ls;

    public Inmueble CrearInmueble(int locadorId, String tipoInmueble, int cantAmb, String direccion, int superficie,
            int cantDormitorio, char aptoProf, String disposicion, int cantBanios, int antiguedadAnios) {

        Locador loc = ls.buscarPorId(locadorId);
        Inmueble i = new Inmueble();

        i.setTipoInmueble(tipoInmueble);
        i.setCantAmb(cantAmb);
        i.setDireccion(direccion);
        i.setSuperficie(superficie);
        i.setCantDormitorio(cantDormitorio);
        i.setAptoProf(aptoProf);
        i.setDisposicion(disposicion);
        i.setCantBanios(cantBanios);
        i.setAntiguedadAnios(antiguedadAnios);

        loc.agregarInmueble(i);
        repo.save(i);
        return i;

    }

    

    public List<Inmueble> getInmuebles(){
        return repo.findAll();

    }

}