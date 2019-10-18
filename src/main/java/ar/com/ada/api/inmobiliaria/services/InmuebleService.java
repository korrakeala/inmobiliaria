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
    InmuebleRepository inmuebleRepo;

    public void CrearInmueble(String tipoInmueble, int cantAmb, String direccion, int superficie, int cantDormitorio, 
    boolean aptoProf, String disposicion, int cantBanios, int antiguedadAnios){

        Inmueble inmueble = new Inmueble ();
        inmueble.setTipoInmueble(tipoInmueble);
        inmueble.setCantAmb(cantAmb);
        inmueble.setDireccion(direccion);
        inmueble.setSuperficie(superficie);
        inmueble.setCantDormitorio(cantDormitorio);
        inmueble.setAptoProf(aptoProf);
        inmueble.setDisposicion(disposicion);
        inmueble.setCantBanios(cantBanios);
        inmueble.setAntiguedadAnios(antiguedadAnios);
        
        //falta agregar union con usuario

        inmuebleRepo.save(inmueble);
        return inmueble;

    }


    
}