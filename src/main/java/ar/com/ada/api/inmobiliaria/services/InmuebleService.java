package ar.com.ada.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Inmueble;
import ar.com.ada.api.inmobiliaria.repo.InmuebleRepository;

/**
 * InmuebleService
 */
@Service
public class InmuebleService {

    @Autowired
    InmuebleRepository repo;

    public Inmueble CrearInmueble(String tipoInmueble, int cantAmb, String direccion, int superficie,
            int cantDormitorio, boolean aptoProf, String disposicion, int cantBanios, int antiguedadAnios) {

        Inmueble i = new Inmueble();
        i.setTipoInmueble(tipoInmueble);
        i.setCantAmb(cantAmb);
        i.setDireccion(direccion);
        i.setReservado(false);
        i.setSuperficie(superficie);
        i.setCantDormitorio(cantDormitorio);
        i.setAptoProf(aptoProf);
        i.setDisposicion(disposicion);
        i.setCantBanios(cantBanios);
        i.setAntiguedadAnios(antiguedadAnios);

        // falta agregar union con usuario

        repo.save(i);
        return i;

    }

}