package ar.com.ada.api.inmobiliaria.entities;

import java.util.*;

/**
 * Locatario
 */
public class Locatario extends Persona {

    int locatarioId;
    List<Reserva> reservas = new ArrayList<Reserva>();
    Usuario usuario;
}