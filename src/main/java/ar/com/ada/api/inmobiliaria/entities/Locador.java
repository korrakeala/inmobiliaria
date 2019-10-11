package ar.com.ada.api.inmobiliaria.entities;

import java.util.*;

/**
 * Locador
 */
public class Locador extends Persona {

    int locadorId;
    List<Inmueble> inmuebles = new ArrayList<Inmueble>();
}