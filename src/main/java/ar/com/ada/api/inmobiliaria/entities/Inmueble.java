package ar.com.ada.api.inmobiliaria.entities;

/**
 * Inmueble
 */
public class Inmueble {

    int inmuebleId;
    int locadorId;
    Locador locador;
    String tipoInmueble;
    String direccion;
    boolean reservado;
    // Coordenada ubicacion; (para usar API Maps a futuro)
    int superficie; //en m2
    int cantDormitorio;
    boolean aptoProf;
    String disposicion;
    int cantBanios;
    String instalaciones;
    int antiguedadAnios;
    // (etc)
    Aviso aviso;
    int avisoId;
}