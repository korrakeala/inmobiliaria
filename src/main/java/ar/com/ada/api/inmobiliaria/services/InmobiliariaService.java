package ar.com.ada.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.repo.InmobiliariaRepository;

/**
 * InmobiliariaService
 */
@Service
public class InmobiliariaService {
    
    @Autowired
    InmobiliariaRepository repo;
    

    
}